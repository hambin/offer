package practical_algorithms.basics;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by hanbing on 2017/7/5.
 * 计算多项式  EXP(x) = 1 + x + x^2/2! + x^3/3! + ...+ x^i/i!     (x^i/i! <= 10^(-10))
 *
 *
 * 后一项 等于 前一项*（x/i）
 */
public class PolynomialCompute {
    public static void main(String[] args){
        int x;
        double s = 1.0, t = 1.0, i = 1;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        while(Math.abs(t) > Math.pow(10, -10)){
            //存在除法运算时，一定要注意是否需要浮点型
            t *= (x/i);
            s += t;
            i++;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(s));
    }
}
