package practical_algorithms.basics;

import java.util.Scanner;

/**
 * Created by hanbing on 2017/7/7.
 *
 * 一次军事演习，A、B 两队约好同一时间从相距 s(50≤s≤100)公里的各自驻地出发相向
 *运动，A 队行进速度为 va 公里/小时(5≤va≤10)，B 队为 vb 公里/小时(4≤vb≤8)。一通迅
 *员骑摩托车从 A 队的驻地也在同一时间为行进中的两队传递信息。摩托车的速度为 vm(30≤
 *vm≤60)60 公里/小时，往返于两队之间，每遇一队立即折回驶向另一队。当两队距离小于
 *0.5 公里时，摩托车停下来不再传递信息。
 *输入
 *s,va,vb,vm
 *输出
 *通讯员跑了多少趟。( 从一队驶向另一队叫一趟)
 *
 * PS: 向A 向B  用flag = 1、-1表示。
 */
public class DistanceComputing {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double s = scanner.nextDouble();
        double va = scanner.nextDouble();
        double vb = scanner.nextDouble();
        double vm = scanner.nextDouble();
        System.out.println(clac(s, va, vb, vm));
    }
    public static int clac(double s, double va, double vb, double vm){
        int flag = 1;
        int count = 0;
        while(s > 0.5){
            if(flag == 1){
                double t = s / (vb + vm);
                s -= (va + vb) * t;
                flag = -1;
                count++;
            }else{
                double t = s / (va + vm);
                s -= (va + vb) * t;
                flag = 1;
                count++;
            }
        }
        return count;
    }
}
