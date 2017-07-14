package sorting;

/**
 * Created by hanbing on 2017/7/13.
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] arr = new int[]{5,4,3,2,1};
        int[] arr1 = new int[]{1,2,6,3,4,5};
        //solution(arr);
        solution1(arr);
        //solution1(arr1);
        solution2(arr1);
        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
    }

    public static void solution(int[] arr){
        int length = arr.length;

        while(length >= 0){
            for(int i = 0; i < length - 1; i++){
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            length--;
        }
    }

    public static void solution1(int[] arr){
        int index = 0;
        int count = 0;
        for(int i = 0 ; i < arr.length - 1; i++){
            boolean flag = false;
            index = i;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(flag == false)
                break;
            count++;
        }
        System.out.println("count = " + count);
    }
    public static void solution2(int[] arr){
        int flag = arr.length;
        int count = 0;
        while(flag > 0){
            int k = flag - 1;
            flag = 0;
            for(int i = 0; i < k; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = i;
                }
            }
            count++;
        }
        System.out.println("count = " + count);
    }
}
