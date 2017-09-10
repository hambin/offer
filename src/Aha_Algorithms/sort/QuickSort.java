package Aha_Algorithms.sort;

import java.util.Random;

/**
 * Created by bing on 2017/6/26.
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right){
        int i, j, temp;

        if(left > right)
            return;
        i = left;
        j = right;
        temp = arr[left];
        while(i != j){
            while(arr[j] >= temp && i < j){
                j--;
            }

            while(arr[i] <= temp && i < j){
                i++;
            }

            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public static void main(String[] args){
        int[] arr = new int[100];

        int test = "abc".length();
        System.out.println(test);

        for(int i = 0; i< arr.length; i++){
            arr[i] = new Random().nextInt(100);
        }

        quickSort(arr, 0, arr.length - 1);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
