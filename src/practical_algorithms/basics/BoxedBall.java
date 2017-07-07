package practical_algorithms.basics;

import java.util.Scanner;

/**
 * Created by hanbing on 2017/7/5.
 * 把 m 个球放入编号为 0，1，2，…，k-1 的 k 个盒中(m<2k)要求第 i 个盒内必须放 2i只
 *球。如果无法满足这一条件，就一个不放，求出放球的具体方案。
 */
public class BoxedBall {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        String binary = Integer.toBinaryString(n);

        if(binary.length() > k){
            System.out.println("can not put in");
        }else{
            String[] arr = binary.split("");
            for(int i = arr.length - 1; i >= 0; i--){
                int num = Integer.parseInt(arr[i]) * (int)(Math.pow(2, (arr.length - 1 - i)));
                System.out.println("the " + (arr.length - 1 - i) + "th box have " + num + " balls");
            }

            for(int i = 0; i < k; i++){
                if(i < arr.length){
                    int num = Integer.parseInt(arr[arr.length - 1 - i]) * (int)(Math.pow(2, i));
                    System.out.println("the " + (i) + "th box have " + num + " balls");
                }else
                    System.out.println("the " + i + "th box have 0 balls");
            }
        }
    }
}
