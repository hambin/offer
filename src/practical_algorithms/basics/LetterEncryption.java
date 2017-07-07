package practical_algorithms.basics;

import java.util.Scanner;

/**
 * Created by hanbing on 2017/7/7.
 *
 * 加密规则是将输入的英文字母下推 K 个顺序后输出。 加密工作直至输入一个非英文字母
 *为止。例如 K=5
 *输入 输出
 *’a’ ’f’
 *’b’ ’g’
 *………
 *’y’ ’d’
 *’Z’ ’E’
 *’0’ 结束
 */
public class LetterEncryption {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char c;
        while(Character.isLetter(c = scanner.next().charAt(0))){
            if(Character.isUpperCase(c)){
                char result = (char)(((c - 'A' + 5) % 26) + 'A');
                System.out.println(result);
            }else
                System.out.println((char)(((c - 'a' + 5) % 26) + 'a'));
        }
    }
}
