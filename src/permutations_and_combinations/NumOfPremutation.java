package permutations_and_combinations;

/**
 * Created by hanbing on 2017/7/14.
 */
public class NumOfPremutation {
    public static void main(String[] args){
        int m = 3;
        //solution(m);
        int[] array = new int[]{2,5, 1};
        solution(array);
    }
    public static void solution(int[] array) {
//        int[] array = new int[m + 1];
//        for (int i = 1; i <= m; i++) {
//            array[i] = i;
//        }
        int count = 1;
        while (true) {
            int n = array.length - 1;
            int i = n, j = n;
            while (i >= 1 && array[i - 1] >= array[i]) {
                i--;
            }
            if(i == 0)
                break;
            while (j >= 1 && array[i - 1] >= array[j]) {
                j--;
            }
//            if(j == 0)
//                break;
            //交换i - 1 和 j 的值
            int temp = array[i - 1];
            array[i - 1] = array[j];
            array[j] = temp;

            //反转i -- m的值
            int bound = ((n - i + 1) / 2) + i;
            for (int k = i; k < bound; k++) {
                temp = array[k];
                array[k] = array[n];
                array[n--] = temp;
            }
            for (i = 0; i < array.length; i++) {
                System.out.print(array[i]);
            }
            System.out.println();
            count++;
        }
    }
}
