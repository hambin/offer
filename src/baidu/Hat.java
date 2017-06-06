package baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bing on 2017/6/6.
 */
public class Hat {
    public static int solution(int[] array) {

        //quickSort(array, 0, array.length - 1);
        insertionSort(array);
        int count = 1;
        int i = 0;
        int result = -1;

        for (int j = 0; j < array.length - 1; j++) {
            if (array[j + 1] != array[j])
                count++;
            if (count == 3) {
                result = array[j + 1];
                break;
            }
        }


        return result;
    }

    public static void quickSort(int[] array, int left, int right) {
        int i, j;
        int pivot;

        if (left < right) {
            pivot = findMid(array, left, right);
            int temp;
            i = left - 1;
            j = right;

            for (; ; ) {
                while (array[++i] < pivot) {
                }
                while (array[--j] > pivot) {
                }

                if (i < j) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }

            temp = array[i];
            array[i] = array[right];
            array[right] = temp;

            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }
    }

    public static void insertionSort(int[] array){
        int i,j,key;
        for(j = 1; j < array.length; j++){
            i = j - 1;
            key = array[j];
            while(i >= 0 && array[i] > key){
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    public static int findMid(int[] array, int left, int right) {
        int center = (left + right) / 2;

        if (array[left] > array[center]) {
            int temp = array[left];
            array[left] = array[center];
            array[center] = temp;
        }
        if (array[left] > array[right]) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        if (array[center] > array[right]) {
            int temp = array[center];
            array[center] = array[right];
            array[right] = temp;
        }

        int temp = array[center];
        array[center] = array[right];
        array[right] = temp;

        return array[right];
    }

    public static void main(String[] args) {
        //int[] array = {3, 5, 6, 2, 8, 3, 5, 9, 1, 2};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n > 50){
            n = scanner.nextInt();
        }
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println(solution(array));
    }
}
