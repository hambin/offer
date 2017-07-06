package practical_algorithms;

import java.util.Scanner;

/**
 * Created by hanbing on 2017/7/5.
 * <p>
 * 有 N 个灯放在一排，从 1 到 N 依次顺序编号。有 N 个人也从 1 到 N 依次编号。1 号将灯
 * 全部关闭，2 将凡是 2 的倍数的灯打开；3 号将凡是 3 的倍数的灯作相反处理(该灯如为打开
 * 的， 则将它关闭；如关闭的，则将它打开)。以后的人都和 3 号一样，将凡是自己编号倍数
 * 的灯作相反处理。试计算第 N 个操作后，哪几盏灯是点亮的。(0-表示灯打开 1-表示灯关闭)
 *
 */
public class TurnTheLight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            if ((i % 2) == 0)
                arr[i] = 1;
            else
                arr[i] = 0;
        }
        for (int i = 3; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if ((j % i) == 0) {
                    if (arr[j] == 0)
                        arr[j] = 1;
                    else
                        arr[j] = 0;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1)
                System.out.print(i + " ");
        }
    }
}
