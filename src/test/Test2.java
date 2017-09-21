package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bing on 2017/9/17.
 */
public class Test2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println(gem(sc.nextLine()));
//        sc.close();
//    }
//
//    public static int gem(String str) {
//        char[] ca = str.toCharArray();
//        int len = str.length();
//        for (int x = 5; x < len; x++) { // x为截取宝石的个数
//            for (int y = 0; y < len; y++) {//y为x确定的情况下迭代的次数
//                StringBuilder temp = new StringBuilder("");
//                for (int z = y; z < y + x; z++) {
//                    temp.append(ca[z % len]);
//                }
//                String t = temp.toString();
//                if (t.contains("A") && t.contains("B") && t.contains("C") && t.contains("D") && t.contains("E")) {
//                    return len - x;
//                }
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args){
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        //while(scanner.hasNext()) {
            int m = scanner.nextInt();
            int[] nums = new int[m];

            for (int i = 0; i < m; i++) {
                nums[i] = scanner.nextInt();
                result += nums[i];
            }

            int i = 0, j = nums.length - 1;

            while (i < j) {
                if (nums[i] == nums[j]) {
                    i++;
                    j--;
                } else {
                    if (nums[i] < nums[j]) {
                        result += nums[i];
                        i++;
                    } else {
                        result += nums[j];
                        j--;
                    }
                }
            }
            System.out.println(result);
        //}
    }
}





//public class 袋鼠过河 {
//    private static int dp[];
//    private static int data[];
//    private static int num;
// 
//            public static int getResult(int val) {
//        if (dp[val] != -2)
//            return dp[val];
//        int max = -1;
//        int inc = data[val];
// 
//        if (inc + val >= num)
//            return 1;
//        for (int i = 1 + val; i <= inc + val; i++) {
//            int res = getResult(i);
// 
//            if (res != -1) {
//                if (max == -1)
//                    max = res;
//                else {
//                    if (res < max)
//                        max = res;
//                }
//            }
//        }
// 
//        if(max != -1)
//            max++;
//        return dp[val] = max;
//    }
// 
//            public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        num = scanner.nextInt();
//        data = new int[num];
//        dp = new int[num];
//        for (int i = 0; i < num; i++) {
//            data[i] = scanner.nextInt();
// 
//            dp[i] = -2;
//        }
//        System.out.println(getResult(0));
//    }
//}
