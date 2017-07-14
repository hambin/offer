package sorting;

import java.util.Random;

/**
 * Created by hanbing on 2017/7/14.
 */
public class QuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(1000);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void quickSort(int[] arr, int start, int end) {
        int low = start;
        int high = end;
        if (low < high) {
            //放在外面会越界
            int sentry = arr[start];
            while(low < high) {
                while (arr[high] >= sentry && low < high)
                    high--;
                while (arr[low] <= sentry && low < high)
                    low++;
                if(low < high) {
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                }
            }
            int temp = arr[low];
            arr[low] = sentry;
            arr[start] = temp;
            quickSort(arr, start, low - 1);
            quickSort(arr, low + 1, end);
        }
    }
}
