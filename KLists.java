import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KLists
{
    public static void main(String[] args)
    {
        //make it one large array and use mergesort?


        //double[][] bigArray = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};  //EXAMPLE ONE
        //double[][] bigArray = {};                                              //EXAMPLE TWO
        //double[][] bigArray = {{}};                                            //EXAMPLE THREE
        double[][] bigArray = {{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};        //UNABLE TO FIGURE OUT WHAT TO DO WITH ARRAY SIZE 3. CANT CUT IT IN HALF.

        double[] finalarray = mergeKLists(bigArray);
        System.out.println("Input: outerArray = "+Arrays.deepToString(bigArray));
        System.out.println("Output: "+Arrays.toString(finalarray));

    }


    public static double [] mergeKLists(double[][] outerArray)
    {
        //CONVERT TO SINGLE ARRAY
        List<Double> temparraylist = new ArrayList<>();  //Creating a list to store values temporarily.
        for (int i = 0; i < outerArray.length; i++) {
            for (int j = 0; j < outerArray[i].length; j++) {
                temparraylist.add(outerArray[i][j]);  //grabs double for each column(i) and each double(j)
            }
        }
        //Move TempArrayList to new double array. *IS THERE A BETTER WAY TO DO THIS?*
        double[] toMergeArray = new double[temparraylist.size()];                      //IS NOW SINGLE ARRAY TO USE
        for (int s = 0; s < toMergeArray.length; s++) {
            toMergeArray[s] = temparraylist.get(s);
        }


        mergesort(toMergeArray);
        return toMergeArray;
    }


    public static double [] get_left(double [] arr)
    {
        int size;
        if (arr.length%2 != 0)
        {
            size = (arr.length/2)+1;
        }
        else
        {
            size = arr.length/2;
        }
        double [] left = new double[size];
        for (int i = 0; i < size; i++) {
            left[i] = arr[i];
        }
        return left;
    }

    public static double [] get_right(double [] arr)
    {
        int size;
        if (arr.length%2 != 0)
        {
            size = (arr.length/2)+1;
        }
        else
        {
            size = arr.length/2;
        }
        double [] right = new double[size];    
        int rightcount = size;
        for (int i = 0; i < size; i++) {
            right[i] = arr[rightcount];
            rightcount++;
        }
        return right;
    }



    public static void mergesort (double [] arr)
    {
        if (arr.length > 1) //recursively call getleft and getright so that it makes smaller trees until array is size 1.
        {
            double [] left = get_left(arr);
            System.out.println(Arrays.toString(left));
            double [] right = get_right(arr);
            System.out.println(Arrays.toString(right));

            mergesort(left);
            mergesort(right);
            merge(arr, left, right);
        }
    }

    //ACTUAL COMPARISONS AND MERGING.
    public static void merge(double[] arr, double[] left, double[] right)
    {
        int left_index = 0;
        int right_index = 0;
        int target_index = 0;

        //going to compare left array and right array element by element.
        while (left_index < left.length && right_index < right.length)
        {
            if (left[left_index] > right[right_index])
            {
                arr[target_index] = right[right_index];
                target_index++;
                right_index++;
            }
            else
            {
                arr[target_index] = left[left_index];
                target_index++;
                left_index++;
            }
        }

        //leftovers on left get added
        while (left_index < left.length)
        {
            arr[target_index] = left[left_index];
            target_index++;
            left_index++;
        }

        //leftovers on right get added
        while (right_index < right.length)
        {
            arr[target_index] = right[right_index];
            target_index++;
            right_index++;
        }

    }
}
