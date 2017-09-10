package canon;

import java.util.*;

/**
 * Created by bing on 2017/8/16.
 */
public class MaxCountOfChar {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        MaxCountOfChar maxCountOfChar = new MaxCountOfChar();
        maxCountOfChar.doString(input);

    }

    public void doString(String input){
        ArrayList<String> array = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();
        ArrayList<String> result = new ArrayList<>();
        char[] charArray = input.toCharArray();
        String maxString = "";

        for(int i = 0; i < charArray.length; i++){
            array.add(String.valueOf(charArray[i]));
            set.add(String.valueOf(charArray[i]));
        }

        Collections.sort(array);
        int max = -1;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < array.size(); i++){
            sb.append(array.get(i));
        }

        String string = sb.toString();

        Iterator<String> its = set.iterator();

        while(its.hasNext()){
            String os = its.next();
            int start = string.indexOf(os);
            int end = string.lastIndexOf(os);
            int value = end - start + 1;
            if(value > max){
                max = value;
                maxString = os;
                result.add(os);
            }else if(value == max){
                result.add(os);
            }
        }

        int index = 0;
        for(int i = 0; i < result.size(); i++){
            if(result.get(i).equals(maxString)) {
                index = i;
                break;
            }
        }
        System.out.println(max);
        for(int i = index; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }

    }
}
