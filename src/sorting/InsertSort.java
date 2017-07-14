package sorting;

import java.util.Random;

/**
 * Created by hanbing on 2017/7/14.
 */
public class InsertSort {
    public static void main(String[] args){
        int[] arr = new int[]{10,9,8,7,6,5,4,3,2,1};
//        Random random = new Random();
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = random.nextInt(10);
//        }
        insertSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "  ");
        }
    }
    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int temp = arr[i];
            //  哨兵值不能改变，要赋值。
            while( j >= 0 && temp < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
