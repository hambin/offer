package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bing on 2017/8/19.
 */
public class SearchPoint {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String inString = scanner.nextLine();
            String[] rowOne = inString.split(" ");
            int size =  Integer.parseInt(rowOne[0]);
            int[] snoArray = new int[size];
            int countOfCommand = Integer.parseInt(rowOne[1]);

            String[] point = scanner.nextLine().split(" ");
            for(int i = 0; i < snoArray.length; i++){
                snoArray[i] = Integer.parseInt(point[i]);
            }

            for(int i = 0; i < countOfCommand; i++){
                String[] command = scanner.nextLine().split(" ");
                if(command[0].equals("Q")){
                    int start = Integer.parseInt(command[1]) - 1;
                    int end = Integer.parseInt(command[2]) - 1;
                    if(start > end){
                        int temp = start;
                        start = end;
                        end = temp;
                    }
                    int max = -1;
                    for(int j = start; j <= end; j++){
                        if(max < snoArray[j])
                            max = snoArray[j];
                    }
                    System.out.println(max);
                }else if(command[0].equals("U")){
                    snoArray[Integer.parseInt(command[1]) - 1] = Integer.parseInt(command[2]);
                }

            }
        }

    }
}
