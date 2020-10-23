import java.util.*;

class Main {

    public static void mergerFunction(int[] arr, int start, int mid, int end, int maxEle) {

        int i = start;
        int j = mid + 1;
        int k = start;

        while(i <= mid && j <= end) {
            
            if(arr[i] % maxEle <= arr[j] % maxEle) {
                arr[k] = arr[k] + (arr[i] % maxEle) * maxEle;
                i++;
            }
            else {
                arr[k] = arr[k] + (arr[j] % maxEle) * maxEle;
                j++;
            }
            k++;
        }

        while(i <= mid) {
            arr[k] = arr[k] + (arr[i] % maxEle) * maxEle;
            i++;
            k++;
        }

        while(j <= end) {
            arr[k] = arr[k] + (arr[j] % maxEle) * maxEle;
            j++;
            k++;
        }


        //setting the elements to needed one in the array
        for(int x = start; x <= end; x++) {
            arr[x] = arr[x] / maxEle;
        }

    }


    public static void mergeSort(int[] arr, int start, int end, int maxEle) {

        if(start < end) {
            int mid = start + (end - start)/2;
            mergeSort(arr, start, mid, maxEle);
            mergeSort(arr, mid + 1, end, maxEle);

            mergerFunction(arr, start, mid, end, maxEle);
        }
    }

    public static void main(String[] args) {
        int[] arr = {30, 2, 33, 21, 54};

        int maxEle = Arrays.stream(arr).max().getAsInt() + 1;

        mergeSort(arr, 0, arr.length - 1, maxEle);

        for(int x: arr) {
            System.out.print(x + " ");
        }
    }
}