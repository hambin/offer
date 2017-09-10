package huawei;

import java.util.*;

/**
 * Created by bing on 2017/8/23.
 *
 * 请编写一个转换字符串的函数：将输入字符串中下标为偶数的字符连成一个新的字符串输出。
 注意:
 1）如果输入字符串的长度超过20， 则转换失败，返回”ERROR!”字符串。
 2）输入字符串只能由0-9数字、小写a-z和大写A-Z组成，如果包含其它字符，则转换失败，返回”ERROR!”字符串。


 函数原型：void ConvertStr (char *str,  char* output);

 输入：

 输入str参数为一个ASCII字符串（C/C++中为0结尾的标准C字符串）。
 输出描述:
 输出：

 若判断输入为合法的字符串，则输出处理后的字符串；

 若输入不合法，则输出字符串”ERROR!”；

 C/C++通过output参数输出结果，可以假定已经为output分配了足够存放结果的内存；

 （请注意添加字符串结尾的0）；

 Java函数请直接通过返回值输出结果。
 */
public class Main {
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        String inedx = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        //while(scanner.hasNext()){
//            String string = scanner.next();
//            char[] check = string.toCharArray();
//            if(check.length > 20) {
//                System.out.println("ERROR");
//                //continue;
//            }
//            for(int i = 0; i < check.length; i++){
//                if((check[i] >= '0' && check[i] <= '9') || (check[i] >= 'a' && check[i] <= 'z') || (check[i] >= 'A' && check[i] <= 'Z')){
//                }else{
//                    System.out.println("ERROR");
//                    //continue;
//                }
//            }
//            String result = null;
//            for(int i = 0; i < check.length; i++){
//                if(i % 2 == 0)
//                    result += check[i];
//            }
//            System.out.println(result);
//        //}
//    }


//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//
//        boolean[] flagB = new boolean[10];
//        for(int i = 0; i< flagB.length; i++){
//            flagB[i] = false;
//        }
//        while(scanner.hasNext()){
//            Set<Character> set = new LinkedHashSet<>();
//            List<Character> list = new LinkedList<>();
//            String num  = scanner.nextLine();
//            String string = String.valueOf(num);
//            char[] nums = string.toCharArray();
//            boolean flag = false;
//            for(int i = 0 ; i < nums.length; i++){
//                if(!(nums[i]>= '0' && nums[i] <= '9'))
//                    return;
//                if(nums[i] != '0')
//                    flag = true;
//            }
//            if(flag == false)
//                return;
//
//
//
//
//            for(int i = 0; i< string.length(); i++){
//                char c = string.charAt(i);
//                int index = c - '0';
//                if(flagB[index] == false){
//                    flagB[index] = true;
//                }else{
//                    string.replaceAll(string.charAt(i), ' ');
//                }
//            }
//            System.out.println(string);
//
//
//
//
//
//
//            for(int i = 0; i < string.length(); i++){
//                set.add(string.charAt(i));
//            }
//            list = new LinkedList<>(set);
//            Collections.sort(list);
//
//        Collections.reverse(list);
//        String result = "";
//        for(int i = 0; i < list.size(); i++){
//            result += list.get(i);
//        }
//        System.out.println(result);
//        }
//    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        int k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        String s = scanner.next();

        int sum = 0;
        char[] nums = s.toCharArray();
        for(int i = nums.length - 1; i > 0; i--){
            sum += (int)nums[i] * Math.pow(n, nums.length - 1 - i);
        }
        List<Character> list = new LinkedList<>();

        while(sum != 0){
            list.add(rev(sum % k));
            sum = sum / k;
        }
        Collections.reverse(list);
        String result = "";
        for(int i =0; i < list.size(); i++){
            result += list.get(i);
        }
        System.out.println(result);
    }


    public static char rev(int a){
        String  s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        return s.charAt(a);
    }
}
