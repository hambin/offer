package data_struct;

import java.util.Arrays;

/**
 * Created by bing on 2017/9/6.
 */
public class TreeByArray {
    public static void main(String[] args){
        TreeByArray tree = new TreeByArray();
        tree.buildTreeByArray();
    }

    public void buildTreeByArray(){
        int i, level;
        int[] data = {6,3,5,9,7,8,4,2};
        int[] bTree = new int[16];
        for(i = 0; i < 16; i++)
            bTree[i] = 0;

        for(i = 0; i < 8; i++){
            for(level = 1; bTree[level] != 0;){
                if(data[i] > bTree[level])
                    level = 2 * level + 1;
                else
                    level = 2 * level;
            }
            bTree[level] = data[i];
        }

        System.out.println(Arrays.toString(bTree));
    }


}
