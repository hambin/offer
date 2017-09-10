package test;

import java.util.*;

/**
 * Created by bing on 2017/6/2.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            List<String> list = new ArrayList<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums = new int[n];
            int result = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {

                list.add(toBinary(nums[i]));
            }

            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.length() - o1.length();
                }
            });

            String check = toBinary(m);

            if (check.length() > list.get(0).length())
                System.out.println(0);
            else {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(i).length() == list.get(j).length()) {
                            StringBuffer sb = new StringBuffer();
                            for (int k = 0; k < list.get(i).length(); k++) {
                                if (list.get(i).charAt(k) == list.get(j).charAt(k))
                                    sb.append(0);
                                else
                                    sb.append(1);
                            }
                            if (Integer.parseInt(sb.toString()) - Integer.parseInt(check) > 0)
                                result++;
                        } else if (list.get(i).length() < list.get(j).length()) {
                            StringBuffer sb = new StringBuffer();
                            int duo = list.get(j).length() - list.get(i).length();
                            int index = 0;
                            while (duo > 0) {
                                sb.append(list.get(j).charAt(index++));
                                list.get(j).substring(index);
                                duo--;
                            }
                            for (int k = 0; k < list.get(i).length(); k++) {
                                if (list.get(i).charAt(k) == list.get(j).charAt(k))
                                    sb.append(0);
                                else
                                    sb.append(1);
                            }
                            if (Integer.parseInt(sb.toString()) - Integer.parseInt(check) > 0)
                                result++;
                        } else {
                            StringBuffer sb = new StringBuffer();
                            int duo = list.get(i).length() - list.get(j).length();
                            int index = 0;
                            while (duo > 0) {
                                sb.append(list.get(i).charAt(index++));
                                list.set(i, list.get(i).substring(index));
                                duo--;
                            }
                            for (int k = 0; k < list.get(i).length(); k++) {
                                if (list.get(i).charAt(k) == list.get(j).charAt(k))
                                    sb.append(0);
                                else
                                    sb.append(1);
                            }
                            if (Integer.parseInt(sb.toString()) - Integer.parseInt(check) > 0)
                                result++;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
    public static String toBinary(int num) {
        StringBuffer sb = new StringBuffer();
        while (num / 2 != 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        sb.append(num);
        return sb.toString();

    }

//    public static void main(String[] args){
//
//        Scanner scanner = new Scanner(System.in);
//        int result = 0;
//        while(scanner.hasNext()){
//            int n = scanner.nextInt();
//
//            int[] nums = new int[n];
//
//            for(int i = 0; i < n; i++)
//                nums[i] = scanner.nextInt();
//            Arrays.sort(nums);
//            int i = 0;
//            for(i = 0; i < nums.length - 2;){
//                if(nums[i + 1] - nums[i] > 10){
//                    result += 2;
//                    ++i;
//                }else if((nums[i + 1] - nums[i]) <= 10 && (nums[i+2] - nums[i + 1]) >= 0){
//                    result += 1;
//                    i += 2;
//                }else if((nums[i + 1] - nums[i]) <= 10 && (nums[i+2] - nums[i + 1]) <= 0){
//                    i += 3;
//                }
//            }
//            int k = nums.length - i;
//            if(k % 3 == 1)
//                result += 2;
//            else if(k % 3 == 2){
//                if(nums[i + 1] - nums[i] <= 20)
//                    result += 1;
//                else
//                    result += 4;
//            }
//        }
//        System.out.println(result);
//    }

}
