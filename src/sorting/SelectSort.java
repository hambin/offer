package sorting;

/**
 * Created by hanbing on 2017/7/13.
 */
public class SelectSort {
    public static void main(String[] args){
        int[] arr = new int[] {6,5,4,3,2,1};
        select(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void select(int[] arr){
        int index = 0;


        for(int i = 0; i < arr.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < min){
                    index = j;
                    min = arr[j];
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
