package test;

import java.util.*;

/**
 * Created by bing on 2017/9/10.
 */
public class TouTiao {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Set<String> headSet = new HashSet<>();
        Set<String> bodySet = new HashSet<>();
        Map<String, Integer> dicMap = new HashMap<>();
        int result = 0;
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for(int i = 0; i < n; i++){
            strings[i] = scanner.next();
        }

        for(String s : strings){
            headSet.add(s.charAt(0)+"");
            for(int i = 0; i < s.length(); i++){
                bodySet.add(s.charAt(i) + "");
            }
        }
        int index = 9;
        Iterator<String> iterator = headSet.iterator();
        while(iterator.hasNext()){
            dicMap.put(iterator.next(), index--);
        }

        bodySet.removeAll(headSet);
        Iterator<String> iterator1 = bodySet.iterator();
        while(iterator1.hasNext()){
            dicMap.put(iterator1.next(), index--);
        }

        for(String s : strings){
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < s.length(); i++){
                sb.append(dicMap.get(s.charAt(i) + ""));
            }
            result += Integer.parseInt(sb.toString());
        }
        System.out.println(result);
    }
}
