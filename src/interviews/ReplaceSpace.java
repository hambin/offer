package interviews;

import java.util.Scanner;

/**
 * Created by bing on 2017/9/21.
 *
 * 替换空格
 *
 * 思路：找出有几个空格，计算出要扩展几位，然后利用setLength来设置新长度。
 * 两个索引，一个跟随原始长度尾部，一个跟随扩展长度尾部
 * 当原始索引为空格时，扩展索引处插入替换值。
 * 部位空格时，扩展索引值为原始索引值
 *
 *
 * 注意setLength（） 和  setCharAt（）  两个函数，  还有insert（）函数的区别。
 */
public class ReplaceSpace {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        StringBuffer sb = new StringBuffer(string);
        //System.out.println("%20");
        replace(sb);
    }

    public static void replace(StringBuffer string){
        int count = 0;
        for(int i = 0 ; i < string.length(); i++){
            if(string.charAt(i) == ' ')
                count++;
        }

        int orign = string.length() - 1;
        int after = string.length() - 1 + 2 * count;
        string.append(" ");
        string.append(" ");
        string.append(" ");
        string.append(" ");
        while(orign >= 0 && orign < after){
            if(string.charAt(orign) == ' '){
                string.setCharAt(after--, '0');
                string.setCharAt(after--, '2');
                string.setCharAt(after--, '%');
            }else{
                string.setCharAt(after--, string.charAt(orign));
            }
            orign--;
        }
        System.out.println(string.toString());
    }
}
