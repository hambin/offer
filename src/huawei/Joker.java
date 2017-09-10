package huawei;

import java.util.Scanner;

/**
 * Created by bing on 2017/8/23.
 */
public class Joker {
    public static void main(String[] args){
        String left, right;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String in = scanner.nextLine();
            String[] pokers = in.split("-");
            left = pokers[0];
            right = pokers[1];

            if(left.equals("joker JOKER") || right.equals("joker JOKER"))
                System.out.println("joker JOKER");
            //else if()
        }
    }

}
