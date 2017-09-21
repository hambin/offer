package data_struct.Tree;

import hundred_algorithms.NumberTB;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by bing on 2017/9/11.
 */
public class BuildTreeByWidth {

    public static void main(String[] args) {
        BuildTreeByWidth tree = new BuildTreeByWidth();

        tree.dataString = "1234#56####78##";
        tree.print(tree.createTree());
        System.out.println();
        tree.widthPrint();

    }

    //
    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    String dataString;
    Node root = null;

    public Node createTree() {
        if (dataString.length() <= 0) {
            return null;
        }
        Node[] nodes = new Node[dataString.length()];
        for (int i = 0; i < (dataString.length() / 2) - 1; i++) {
            if (dataString.charAt(i) != '#') {
                if (nodes[i] == null) {
                    nodes[i] = new Node(dataString.charAt(i) - '0');
                }
                int index = 2 * i + 1;
                if (index < dataString.length() && dataString.charAt(index) != '#') {
                    nodes[index] = new Node(dataString.charAt(index) - '0');
                    nodes[i].left = nodes[index];
                } else {
                    nodes[i].left = null;
                }
                index++;
                if (index < dataString.length() && dataString.charAt(index) != '#') {
                    nodes[index] = new Node(dataString.charAt(index) - '0');
                    nodes[i].right = nodes[index];
                } else {
                    nodes[i].right = null;
                }
            }
        }
        root = nodes[0];
        return nodes[0];
    }

    public void print(Node node) {
        if (node == null) {
            System.out.print("$, ");
            return;
        }
        print(node.left);
        System.out.print(node.value + ", ");
        print(node.right);

    }

    public void widthPrint() {
        Node last = root;
        Node nLast = null;
        Queue<Node> queue = new LinkedBlockingQueue<>();

        queue.add(last);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
                nLast = temp.left;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nLast = temp.right;
            }
            if (temp == last) {
                System.out.println(temp.value);
                last = nLast;
            } else {
                System.out.print(temp.value + " ");
            }
        }
    }


}
