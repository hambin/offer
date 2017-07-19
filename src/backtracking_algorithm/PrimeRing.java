package backtracking_algorithm;

/**
 * Created by hanbing on 2017/7/19.
 */
public class PrimeRing {
    public static int n = 10;
    static boolean[] vis = new boolean[n + 1];
    static int[] arr = new int[n + 1];
    public static void main(String[] args) {
        arr[0] = 0;
        init();
        solution(1);
    }

    public static void init(){
        for(int i = 0; i < vis.length; i++){
            vis[i] = false;
        }
    }

    public static void solution(int cur) {
        if (cur == n + 1 && isPrime(arr[1] + arr[n]) && arr[1] == 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++){
                if(!vis[i] && isPrime(i + arr[cur - 1])){
                    vis[i] = true;
                    arr[cur] = i;
                    solution(cur + 1);
                    vis[i] = false;
                }
            }
        }
    }

    public static boolean isPrime(int elem) {
        for (int i = 2; i <= Math.sqrt(elem); i++) {
            if (elem % i == 0) {
                return false;
            }
        }
        return true;
    }
}
