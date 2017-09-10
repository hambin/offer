package canon;

/**
 * Created by bing on 2017/8/31.
 *
 * 筛选出 100 以内的素数
 */
public class ScreenThePrime {

//    public static void main(String[] args){
//        int[] nums = new int[101];
//        for(int i = 1; i < 101; i++){
//            nums[i] = 1;
//        }
//
//        for(int i = 2; i < 101; i++){
//            if(nums[i] != 0){
//                for(int j = i + i; j < 101;){
//                    if(j % i == 0){
//                        nums[j] = 0;
//                        j += i;
//                    }
//                }
//            }
//        }
//
//        for(int i = 1; i < 101; i++){
//            if(nums[i] != 0)
//                System.out.print(i + " ");
//        }
//    }

    public static void main(String[] args){
        int[] nums = new int[101];
        int i, j, k;
        for(i = 1; i < 100; i++){
            k = (int) Math.sqrt(i);
            for(j = 2; j <= k; j++){
                if(i % j == 0)
                    break;
            }
            if(j > k)
                System.out.print(i + " ");
        }
    }
}
