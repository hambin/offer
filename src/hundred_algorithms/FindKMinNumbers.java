package hundred_algorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bing on 2017/9/7.
 * 查找最小的 k 个元素 题目：输入 n 个整数，输出其中最小的 k 个。
 * 例如输入 1，2，3，4，5，6，7 和 8 这 8 个数字，则最小的 4 个数字为 1，2，3 和 4。
 */
public class FindKMinNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[]{1,6,43,67,9,345,56,78,32};
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < k; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        for(int i = k; i < nums.length; i++){
            if(nums[i] < list.get(k - 1)){
                int j = k - 1;
                while(nums[i] < list.get(j)){
                    j--;
                }
                list.add(j + 1, nums[i]);
                list.remove(k);
            }
        }

        for(int i : list)
            System.out.println(i);
    }
}
