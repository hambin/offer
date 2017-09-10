package canon;

/**
 * Created by bing on 2017/8/27.
 */
/*
利用1，2，2，3，4这五个数，打印出所有不同的排列，要求打印出来的不能有重复
 */
public class PrintAllNumber {
//    public static void main(String[] args){
//        String begin = "12234";
//        char[] chars = begin.toCharArray();
//        int[] nums = new int[begin.length()];
//        for(int i = 0; i < chars.length; i++){
//            nums[i] = chars[i] - '0';
//        }
//        System.out.print(begin + " ");
//        while(true){
//            int i = nums.length - 1;
//            int j = nums.length - 1;
//
//            while(i >= 1 && nums[i - 1] >= nums[i]){
//                i--;
//            }
//            if(i == 0)
//                break;
//
//            while(j >= 1 && nums[j] <= nums[i - 1]){
//                j--;
//            }
//
//            int temp = nums[i - 1];
//            nums[i - 1] = nums[j];
//            nums[j] = temp;
//            int rear = nums.length - 1;
//            int bound = (nums.length - i + 1) / 2;
//            for(int k = i; k < bound + i; k++){
//                int index = nums[k];
//                nums[k] = nums[rear];
//                nums[rear--] = index;
//            }
//            for(int in = 0; in < nums.length; in++){
//                System.out.print(nums[in]);
//            }
//            System.out.println();
//        }
//    }


    public static void main(String[] args){
        String input = "2131";
        //fullPermutate(0, "", input);
        System.out.println();
        char[] chars = input.toCharArray();
        fullPermutate1(chars, 0, chars.length - 1);
    }
    //全排列算法，不含重复元素,index为此次调用确定的位，path为已经确定的位，string为整串。
    public static void fullPermutate(int index, String path, String string){
        String restStr = stringSub(path, string);

        if(index == string.length()){
            System.out.println(path);
            return;
        }else{
            for(int i = 0; i < string.length() - index; i++){
                fullPermutate(index + 1, path + restStr.charAt(i), string);
            }
        }
    }
    //返回整串和已经排列的串的差值
    public static String stringSub(String path, String string){
        String restStr = "";
        for(int i = 0; i < string.length(); i++){
            if(!path.contains(string.charAt(i) + "")){
                restStr += string.charAt(i);
            }
        }
        return restStr;
    }


    //全排列算法，from - to
    public static void fullPermutate1(char[] chars, int from, int to){
        if(to <= 1){
            return;
        }
        if(from == to){
            System.out.println(chars);
        }else{
            for(int i = from; i <= to; i++){
                if(isSwap(chars, from, i)) {
                    swap(chars, i, from);
                    fullPermutate1(chars, from + 1, to);
                    swap(chars, from, i);
                }
            }
        }

    }

    public static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    public static boolean isSwap(char[] chars, int from, int i){
        boolean flag = true;
        for(int k = from; k < i; k++){
            if(chars[k] == chars[i])
                flag = false;
        }
        return flag;
    }
}
