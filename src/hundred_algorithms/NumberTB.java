package hundred_algorithms;

import java.util.Arrays;

/**
 * Created by bing on 2017/9/8.
 * 根据上排给出十个数，在其下排填出对应的十个数
 * 要求下排每个数都是先前上排那十个数在下排出现的次数。
 * 上排的十个数如下：
 *【0，1，2，3，4，5，6，7，8，9】
 * 举一个例子，
 * 数值: 0,1,2,3,4,5,6,7,8,9
 * 分配: 6,2,1,0,0,0,1,0,0,0
 * 0在下排出现了6次，1在下排出现了2次，
 * 2在下排出现了1次，3在下排出现了0次....
 *
 */
public class NumberTB {

    boolean success = false;
    int[] top = new int[]{0,1,2,3,4,5,6,7,80,10};
    int[] bottom = new int[10];

    public static void main(String[] args) {
        NumberTB numberTB = new NumberTB();
        numberTB.getBottom();
    }

    public void getBottom() {
        while(!success){
            setBottom();
        }
        System.out.println(Arrays.toString(bottom));

    }

    public void setBottom() {
        boolean flag = true;
        for (int i = 0; i < top.length; i++) {
            int frequency = getFrequency(top[i]);
            if (bottom[i] != frequency) {
                bottom[i] = frequency;
                flag = false;
            }
        }
        System.out.println(Arrays.toString(bottom));
        success = flag;
    }


    public int getFrequency(int num) {
        int count = 0;
        for (int i = 0; i < bottom.length; i++) {
            if (bottom[i] == num) {
                count++;
            }
        }
        return count;
    }
}
