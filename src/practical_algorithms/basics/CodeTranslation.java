package practical_algorithms.basics;

import java.util.Scanner;

/**
 * Created by hanbing on 2017/7/7.
 *
 * 输入一个以’@’结束的字符串，从左至右翻译。若下一个字符是数字 n(0≤n≤9)，表
 *示后一个字符重复 n+1 次，不论后一个字符是否为数字；若下一个字符非数字，则表示自己。
 *翻译后，以 3 个字符为一组输出，组与组之间用空格分开。例如’A2B5E34FG0ZYWPQ59R@’ ，
 *翻译成’ABB_BEE_EEE_E44_44F_GZY_WPQ_999_999_R@ ’ 。
 *输入
 *字符串（串长≤255） ；
 *输出
 *翻译后的字符串；
 *
 *
 * PS:字符串转字符数组
 */
public class CodeTranslation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int flag = 0;
        if(str.length() > 255){
            System.out.println("字符串过长，请重新输入：");
            str = scanner.nextLine();
        }
        char[] charArr = str.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            if(!Character.isDigit(charArr[i])){
                if(flag % 3 == 0 && flag != 0)
                    System.out.print("_");
                System.out.print(charArr[i]);
                flag++;
            }else{
                int temp = charArr[i] - '0';
                i++;
                for(int j = 0; j <= temp; j++){
                    if(flag % 3 == 0 && flag != 0)
                        System.out.print("_");
                    System.out.print(charArr[i]);
                    flag++;
                }
            }
            if(charArr[i] == '@')
                break;
        }
    }
}
