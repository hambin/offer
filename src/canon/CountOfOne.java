package canon;

/**
 * Created by bing on 2017/8/29.
 *
 * 有一个整数n，写一个函数，返回0-n之间出现的"1"的个数。
 */
public class CountOfOne {
    public static void main(String[] args){
        int n = 13;
        int res = 0;
        int index = 0;
        do{
            res += getOnly(index);
            ++index;
        }while(index <= n);
        System.out.println(n);
        System.out.println(res);
    }
    static int getOnly(int num){
        int number = 0;
        String s = num + "";
        int len = s.length();
        if(len != 0){
            for(int i = 0; i < len; i++){
                char c = s.charAt(i);
                if(c == '1')
                    number++;
            }
        }
        return number;
    }
}
