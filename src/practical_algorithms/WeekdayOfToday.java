package practical_algorithms;

import java.util.Scanner;

/**
 * Created by hanbing on 2017/7/5.
 * 按照年 月 日的格式输入今天的日期。计算和输出今天是星期几的信息。
 *
 */
public class WeekdayOfToday {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int year, month, day;
        year = scanner.nextInt();
        month = scanner.nextInt();
        day = scanner.nextInt();

        //计算0000年到去年的所有天数余7的值，闰年余2，平年余1
        int y = ((year - 1) / 4) - ((year - 1) / 100) + ((year - 1) / 400) + 1 * (year - 1);
        int m = 0;
        if(month == 1 || month == 10){
            m = 0;
        }else if(month == 2 || month == 3 || month == 11){
            m = 3;
        }else if(month == 4 || month == 7){
            m = 6;
        }else if(month == 5){
            m = 1;
        }else if(month == 6){
            m = 4;
        }else if(month == 8){
            m = 2;
        }else if(month == 9 || month == 12){
            m = 5;
        }

        if((((year % 4) == 0) && (year % 100) != 0) || (year % 400) == 0){
            m = m + 1;
        }

        System.out.println((y + m + day) % 7);

    }
}
