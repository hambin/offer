package hundred_algorithms;

/**
 * Created by bing on 2017/9/6.
 */
public class MaxPlusOfArray {
    public static void main(String[] args) {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        int min, max = 0, indexL, indexH;
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            if(sum < 0)
                sum = array[i];
            else
                sum += array[i];

            if(max < sum)
                max = sum;
        }
        System.out.println(max);
    }
}
