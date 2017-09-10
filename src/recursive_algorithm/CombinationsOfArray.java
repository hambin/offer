package recursive_algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bing on 2017/8/16.
 */
public class CombinationsOfArray  {
    public static void main(String[] args){
        String[] array = new String[]{"1", "2", "3"};
        listAll(Arrays.asList(array), "");
    }
    public static void listAll(List candidate, String prefix){
        System.out.println(prefix);
        for(int i= 0; i < candidate.size(); i++){
            List temp = new LinkedList(candidate);
            listAll(temp, prefix + temp.remove(i));
        }
    }
}
