package data_struct.graph;

import java.util.*;

/**
 * Created by bing on 2017/9/14.
 */
public class TencentMagicCity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int INF = Integer.MAX_VALUE;
        int n = scanner.nextInt();
        int k = scanner.nextInt();

//        int[][] matrix = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = scanner.nextInt();
//            }
//        }
        int[][] matrix = {
                {0,2,5,7},
                {2,0,2,3},
                {5,2,0,2},
                {7,3,2,0}
        };
        TencentMagicCity tencentMagicCity = new TencentMagicCity();
        Set<Integer> list = new TreeSet<>();
        tencentMagicCity.findMinPath(0, 1, matrix, list);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }

    public Set<Integer> findMinPath(int start, int end, int[][] matrix, Set<Integer> result) {
        boolean[] flag = new boolean[matrix.length];

        for (int i = 0; i < flag.length; i++) {
            flag[i] = false;
        }

        flag[start] = true;
        int index = 0;
        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                if (flag[j] == false && min > matrix[0][j]) {
                    min = matrix[0][j];
                    index = j;
                }
            }

            flag[index] = true;


            for (int k = 0; k < matrix.length; k++) {
                int temp = matrix[index][k] == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + matrix[index][k];

                if (flag[k] == false && temp < matrix[0][k]) {
                    matrix[0][k] = temp;
                    result.add(index);
                }
//                else if(flag[k] == false && temp > matrix[0][k])
//                    result.add(k);
            }
            if (flag[end] == true) {
                return result;
            }

        }
        return null;
    }
}
