package huawei;

import java.util.*;

/**
 * Created by bing on 2017/8/21.
 */
public class ErrorLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> result = new TreeMap<>();
        //while (scanner.hasNext()) {
        for (int i = 0; i < 100; i++) {

            String string = scanner.next();
            int id = string.lastIndexOf('\\');
            String fileName = (id < 0 ? string : string.substring(id + 1));
            int lineNum = scanner.nextInt();
            String key = fileName + "_" + lineNum;
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + 1);
            } else {
                result.put(key, 1);
            }
        }
        //}

        List<Map.Entry<String, Integer>> list = new ArrayList<>(result.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        int flag = 1;
        for (Map.Entry<String, Integer> l : list) {
            if (flag > 8)
                break;
            flag++;

            String[] str = l.getKey().split("_");
            String k = str[0].length() > 16 ? str[0].substring(str[0].length() - 16) : str[0];
            String n = str[1];
            System.out.println(k + " " + n + " " + l.getValue());
        }
    }
}


