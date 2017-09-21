package data_struct.graph;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by bing on 2017/9/14.
 */
public class MatrixUDG {
    private int mEdgNum;//边的数量
    private char[] mVexs;//顶点集合
    private int[][] mMarix;//邻接矩阵
    private static final int INF = Integer.MAX_VALUE; //最大值

    Scanner scanner = new Scanner(System.in);

    /*
    自己输入数据创建图
     */
    public MatrixUDG() {

        //输入顶点数和边数
        int vLen = scanner.nextInt();
        int eLen = scanner.nextInt();
        if (vLen < 1 || eLen < 1 || eLen > (vLen * (vLen - 1)))
            return;

        mVexs = new char[vLen];
        for (int i = 0; i < vLen; i++) {
            mVexs[i] = readChar();
        }

        mEdgNum = eLen;
        mMarix = new int[vLen][vLen];
        ;
        for (int i = 0; i < vLen; i++) {
            for (int j = 0; j < vLen; j++) {
                if (i == j)
                    mMarix[i][j] = 0;
                else
                    mMarix[i][j] = INF;
            }
        }
        for (int i = 0; i < eLen; i++) {
            char c1 = readChar();
            char c2 = readChar();
            int weight = scanner.nextInt();

            int p1 = getPosition(c1);
            int p2 = getPosition(c2);

            if (p1 != -1 && p2 != -1) {
                mMarix[p1][p2] = weight;
                mMarix[p2][p1] = weight;
            }
        }
    }


    /*
    用已提供的矩阵创建图
     */
    public MatrixUDG(char[] vexs, int[][] matrix) {
        int vLen = vexs.length;
        mVexs = new char[vLen];
        for (int i = 0; i < vLen; i++) {
            mVexs[i] = vexs[i];
        }

        mMarix = new int[vLen][vLen];
        for (int i = 0; i < vLen; i++) {
            for (int j = 0; j < vLen; j++) {
                mMarix[i][j] = matrix[i][j];
            }
        }
        mEdgNum = 0;
        for (int i = 0; i < vLen; i++) {
            for (int j = i + 1; j < vLen; j++) {
                if (mMarix[i][j] != INF)
                    mEdgNum++;
            }
        }
    }

    public char readChar() {
        char ch = '0';
        do {
            try {
                ch = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')));
        return ch;
    }

    public int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i] == ch)
                return i;
        }
        return -1;
    }


    //Dijkstra算法寻找最短路径
    public void dijkstra(int vs, int[] prev, int[] dist) {
        boolean[] flag = new boolean[mVexs.length];

        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;
            prev[i] = 0;
            dist[i] = mMarix[vs][i];
        }

        flag[vs] = true;
        dist[vs] = 0;

        int k = 0;
        for (int i = 1; i < mVexs.length; i++) {
            int min = INF;
            for (int j = 0; j < mVexs.length; j++) {
                if (flag[j] == false && min > dist[j]) {
                    min = dist[j];
                    k = j;
                }
            }

            flag[k] = true;

            for (int j = 0; j < mVexs.length; j++) {
                int temp = (mMarix[k][j] == INF ? INF : mMarix[k][j] + min);
                if (flag[j] == false && dist[j] > temp) {
                    dist[j] = temp;
                    prev[j] = k;
                }
            }
        }
        for(int p = 0; p < mVexs.length; p++){
            System.out.print(prev[p] + " ");

        }
        System.out.println();
        System.out.printf("dijkstra(%c): \n", mVexs[vs]);
        for (int i = 0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs], mVexs[i], dist[i]);
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
          /*A*/ {0, 12, INF, INF, INF, 16, 14},
          /*B*/ {12, 0, 10, INF, INF, 7, INF},
          /*C*/ {INF, 10, 0, 3, 5, 6, INF},
          /*D*/ {INF, INF, 3, 0, 4, INF, INF},
          /*E*/ {INF, INF, 5, 4, 0, 2, 8},
          /*F*/ {16, 7, 6, INF, 2, 0, 9},
          /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        MatrixUDG pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new MatrixUDG();
        // 采用已有的"图"
        pG = new MatrixUDG(vexs, matrix);

        //pG.print();   // 打印图
        //pG.DFS();     // 深度优先遍历
        //pG.BFS();     // 广度优先遍历
        //pG.prim(0);   // prim算法生成最小生成树
        //pG.kruskal(); // Kruskal算法生成最小生成树

        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
        pG.dijkstra(3, prev, dist);
    }

}
