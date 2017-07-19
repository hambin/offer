package recursive_algorithm;

/**
 * Created by hanbing on 2017/7/19.
 */
public class OilStoragePoint {
    public static void main(String[] args){

        double[] dis = new double[10];
        double[] oil = new double[10];

        solution(dis, oil);

    }
    public static void solution(double[] dis, double[] oil){
        //保证最后一个储油点存着500L油，所以距离显然是距离终点500KM
        dis[1] = 500.0;
        oil[1] = 500.0;

        int pointNo = 2;

        while(true){
            dis[pointNo] = dis[pointNo - 1] + (500.0 / (2 * pointNo - 1));
            oil[pointNo] = oil[pointNo - 1] + 500.0;
            if(dis[pointNo] >= 1000.0)
                break;
            pointNo++;
        }
        double surplusDis = 1000.0 - dis[pointNo - 1];
        oil[pointNo] = oil[pointNo - 1] + surplusDis * (2 * pointNo - 1);
        System.out.println(oil[pointNo]);
    }
}
