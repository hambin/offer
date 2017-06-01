package RebuildBinaryTree;

import java.util.List;

/**
 * Created by bing on 2017/5/31.
 *
 * 根据前序中序重构二叉树
 *
 * 前序第一位必然是根节点，找出中序中的位置，左边递归左子树，右边递归右子树，注意下标
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Rebuild {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {


        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0 , in.length - 1);

    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                // right subTree is started of left subTree's end + 1 in pre.
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }

        return root;
    }

    public void prePrint(TreeNode root){
        if(root != null) {

            prePrint(root.left);
            System.out.println(root.val);

            prePrint(root.right);
        }
    }

    public static void main(String[] args){
        int[] preArray = {1,2,4,7,3,5,6,8};
        int[] inArray = {4,7,2,1,5,3,8,6};
        Rebuild rb = new Rebuild();
        TreeNode root = rb.reConstructBinaryTree(preArray, inArray);
        rb.prePrint(root);
    }
}
