import java.util.*;

class Main {

    public static int mergeFunction(int[] arr, int start, int mid, int end) {

        int[] leftArr = new int[mid - start + 1];
        for(int i = 0; i< leftArr.length; i++) {
            leftArr[i] = arr[i + start];
        }

        int[] rightArr = new int[end - mid];
        for(int j = 0; j < rightArr.length; j++) {
            rightArr[j] = arr[j + mid + 1];
        }

        int i = 0;
        int j = 0;
        int k = start;
        int currentInversions = 0;

        while(i < leftArr.length && j < rightArr.length) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                currentInversions += (leftArr.length - i);
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j < rightArr.length) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        return currentInversions;
    }

    public static int mergeSort(int[] arr, int start, int end) {

        int result = 0;
        if(start < end) {
            int mid = (start + end) / 2;
            
            result += mergeSort(arr, start, mid);
            result += mergeSort(arr, mid + 1, end);

            int thisLevelInversion = mergeFunction(arr, start, mid, end);
            // System.out.println(thisLevelInversion);
            result += thisLevelInversion;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};

        int result = mergeSort(arr, 0, arr.length - 1);
        System.out.println(result);
    }
}