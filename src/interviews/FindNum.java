package interviews;

/**
 * Created by bing on 2017/9/21.
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class FindNum {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };
        System.out.println(find(array, 0));

    }

    public static boolean find(int[][] array, int key) {
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (key == array[i][j]) {
                return true;
            } else if (key < array[i][j]) {
                j = j - 1;
            } else {
                i = i + 1;
            }
        }
        return false;
    }
}
