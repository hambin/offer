package codeM;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by bing on 2017/6/25.
 */
public class BWTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n < 1 || n > 100000) {
            n = scanner.nextInt();
        }
        int[] links = new int[n - 1];
        for (int i = 0; i < links.length; i++)
            links[i] = scanner.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++)
            values[i] = scanner.nextInt();

        System.out.println(findMinCount(n, values, links));
    }

    public static int findMinCount(int n, int[] values, int[] links) {
        TreeNode root = new TreeNode(1, values[0], null, null, 0);
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        for (int i = 1; i < n; i++) {
            nodes.add(new TreeNode(i + 1, values[i], null, null, 0));
        }

        for (int i = 0; i < nodes.size(); i++) {
            System.out.println(nodes.get(i).getValue());
        }
        for (int i = 0; i < links.length; i++) {
            nodes.get(i + 1).setParent(nodes.get(links[i] - 1));
        }
        Collections.sort(nodes);
        int count = 0;
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            if (node.getFlag() == 0) {
                int value = node.getValue();
                while (value > 0) {
                    if (node.getFlag() == 0) {
                        node.setFlag(1);
                    }
                    if(node.getParent() != null)
                        node = node.getParent();
                    value--;
                }
                count++;
            }
        }

        return count;
    }

}

class TreeNode implements Comparable<TreeNode> {
    int no;
    int value;
    TreeNode parent;
    TreeNode child;
    int flag;

    public TreeNode(int no, int value, TreeNode parent, TreeNode child, int flag) {
        this.no = no;
        this.value = value;
        this.parent = parent;
        this.child = child;
        this.flag = flag;
    }

    public void setChild(TreeNode child) {
        this.child = child;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode getChild() {
        return child;
    }

    public int getValue() {
        return value;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public int compareTo(TreeNode o) {
        return -(value - o.value);
    }
}
