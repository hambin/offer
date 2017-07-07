package practical_algorithms.basics;

/**
 * Created by hanbing on 2017/7/7.
 * <p>
 * 求 1/1+1/2+2/3+3/5+5/8+…前 n 项（n≤50）的和（保留小数点后 2 位） 。
 */
public class SequenceComputing {
    public static void main(String[] args) {

        double a = 1;
        double b = 1;
        int flag = 4;
        double s = 0;
        while (flag > 0) {
            s = s + (a / b);
            double c = b;
            b = c + a;
            a = c;
            flag--;
        }
        System.out.println(String.format("%.2f", s));
    }
}
