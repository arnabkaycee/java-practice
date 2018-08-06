package LarrysArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort<E extends Comparable<E>> {


    public int inversions = 0;

    private void merge(E[] arr, int startIndex, int mid, int endIndex) {

        //copy the array from startIndex to mid to one array
        E[] firstHalf = Arrays.copyOfRange(arr, startIndex, mid + 1);
        //copy the array from mid+1 index to endIndex
        E[] secondHalf = Arrays.copyOfRange(arr, mid + 1, endIndex + 1);

        //start the merging process
        int mainArrayIndex = startIndex, firstArrayIndex = 0, secondArrayIndex = 0;

        while (firstArrayIndex < firstHalf.length && secondArrayIndex < secondHalf.length) {
            if (firstHalf[firstArrayIndex].compareTo(secondHalf[secondArrayIndex]) > 0) {
                ++inversions;
                arr[mainArrayIndex++] = secondHalf[secondArrayIndex++];
            } else {
                arr[mainArrayIndex++] = firstHalf[firstArrayIndex++];
            }
        }
        //copy leftovers
        while (firstArrayIndex < firstHalf.length) {
            arr[mainArrayIndex++] = firstHalf[firstArrayIndex++];
        }
        while (secondArrayIndex < secondHalf.length) {
            arr[mainArrayIndex++] = secondHalf[secondArrayIndex++];
        }
    }

    public void sort(E[] arr, int startIndex, int endIndex) {
        if ((endIndex - startIndex) < 1) {
            return;
        }
        int mid = ((endIndex + startIndex) / 2);
        sort(arr, startIndex, mid);
        sort(arr, mid + 1, endIndex);
        merge(arr, startIndex, mid, endIndex);
    }

//    public static void main(String[] args) {
//        MergeSort<Integer> obj = new MergeSort<Integer>();
////        Integer[] arr = new Integer[5];
////        arr[0] = 5;
////        arr[1] = 4;
////        arr[2] = 3;
////        arr[3] = 1;
////        arr[4] = 2;
//        //Arrays
//        long start = System.currentTimeMillis();
//        obj.sort(arr, 0, arr.length - 1);
//        long end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
//        System.out.println(end - start);
//        System.out.println(obj.inversions);
//    }
}
