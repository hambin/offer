package practical_algorithms.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanbing on 2017/7/7.
 *
 * 计算成等差数列的素数
 */
public class ArithmeticPrimes {
    public static void main(String[] args){
        solution(50);
    }
    public static void solution(int m){
        List<Integer> arr = new ArrayList<>();
        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i <= m; i++){
            arr.add(i);
        }

        while(arr.size() != 0){
            primes.add(arr.get(0));
            int k = arr.get(0);
            for(int i = 0; i < arr.size(); i++){
                if((arr.get(i) % k) == 0)
                    arr.remove(i);
            }
        }
        System.out.println(primes.toString());
    }
}
