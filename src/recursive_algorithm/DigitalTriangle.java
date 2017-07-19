package recursive_algorithm;

import java.util.Scanner;

/**
 * Created by hanbing on 2017/7/17.
 */
public class DigitalTriangle {
    public static void main(String[] args){
        int[][] array = new int[5][5];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<= 4;i++){
            for(int j = 0; j<=i;j++){
                array[i][j] = scanner.nextInt();
            }
        }
        solution(array);
    }

    public static void solution(int[][] array){
        int n = array.length - 1;
        for(int i = n - 1; i >=0; i--){
            for(int j = 0; j <= i; j++){
                if(array[i+1][j] > array[i+1][j+1])
                    array[i][j] += array[i+1][j];
                else
                    array[i][j] += array[i+1][j+1];
            }
        }
        System.out.println(array[0][0]);
    }
}
