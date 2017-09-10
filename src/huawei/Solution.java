package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bing on 2017/8/23.
 */
public class Solution {
    /**
     * 交换数组里n和0的位置
     *
     * @param array
     *            数组
     * @param len
     *            数组长度
     * @param n
     *            和0交换的数
     */
    // 不要修改以下函数内容
    public void swapWithZero(int[] array, int len, int n) {
        int indexOfn = 0;
        int indexOfZero = 0;
        for(int i = 0; i < len; i++){
            if(array[i] == n)
                indexOfn = i;
            if(array[i] == 0)
                indexOfZero = i;
        }
        int temp = array[indexOfn];
        array[indexOfn] = array[indexOfZero];
        array[indexOfZero] = temp;
    }
    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array
     *            存储有[0,n)的数组
     * @param len
     *            数组长度
     */
    public void sort(int[] array, int len) {
        // 完成这个函数
        int indexOfMax = 0;

        while(len > 0){
            swapWithZero(array, len, array[len - 1]);
            int max = -1;
            for(int i = 0; i < len - 1; i++){
                if(array[i] > max) {
                    max = array[i];
                    indexOfMax = i;
                }
            }
            swapWithZero(array, len, array[indexOfMax]);
            len--;
        }

    }

    public static void main(String[] args){
        int[] array = new int[]{0,3,2,1};
        Solution solution = new Solution();
        solution.sort(array, 4);
        System.out.println(Arrays.toString(array));
    }
}