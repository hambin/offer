package test;


import java.util.*;

/**
 * Created by bing on 2017/9/13.
 */
public class Test {

//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            String num = scanner.next();
//            int k = scanner.nextInt();
//            char[] nums = num.toCharArray();
//            for(int i = 0; i < k; i++){
//                boolean flag = false;
//                for(int j = 0; j < num.length() - 1; j++){
//                    if(num.charAt(j) < num.charAt(j + 1)){
//                        num = num.substring(0, j) + num.substring(j + 1, num.length());
//                        flag = true;
//                        break;
//                    }
//                }
//                if(flag == false)
//                    num = num.substring(0, num.length() - 1);
//            }
//            System.out.println(num);
//        }
//    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String string = scanner.next();

            System.out.println(simple(string));
        }

    }

    public static String simple(String string){

        Stack<String> stack = new Stack<>();
        String[] strings = string.split("/");
        List<String> list = new ArrayList<>();
        for(int i = 0; i < strings.length; i++){
            if(!strings[i].equals(".") && !strings[i].equals("..") && !strings[i].equals("")){
                stack.push(strings[i]);
            }else if(strings[i].equals("."))
                continue;
            else if(strings[i].equals(".."))
                stack.pop();
        }
        if(stack.isEmpty())
            return "/";
        else{
            String result = "";
            while (!stack.isEmpty()){
                list.add(stack.pop());

            }
            for(int i = list.size() - 1; i >= 0; i--){
                result += "/" + list.get(i);
            }
            return result;
        }
    }

//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//
//        String string = scanner.nextLine();
//
//        String[] strings = string.split(" ");
//        int[] nums = new int[strings.length];
//
//        for(int i = 0; i < nums.length; i++){
//            nums[i] = Integer.parseInt(strings[i]);
//        }
//
//
//    }

}
