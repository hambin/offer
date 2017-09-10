package hundred_algorithms;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by bing on 2017/9/7.
 */
public class FindPathOfTree {

    public static void main(String[] args){
        //Node root = new Node(10);
        Node node1 = new Node(4);
        Node node2 = new Node(7);
        Node node3 = new Node(5, node1, null);
        Node node4 = new Node(12, null, node2);
        Node node5 = new Node(10, node3, node4);

        int currentSum = 0;
        int expectSum = 19;
        Stack<Integer> stack = new Stack<>();

        findPath(node5, currentSum, expectSum, stack);

    }

    public static void findPath(Node node, int currentSum, int expectSum, Stack<Integer> stack){
        if(node == null){
            return;
        }

        currentSum += node.value;
        stack.push(node.value);
        boolean isLeaf = (node.leftNode == null) && (node.rightNode == null);
        if(currentSum == expectSum && isLeaf){
            Iterator<Integer> iterator = stack.iterator();
            while(iterator.hasNext())
                System.out.print(iterator.next() + " ");
        }else{
            if(node.leftNode != null)
                findPath(node.leftNode, currentSum, expectSum, stack);
            if(node.rightNode != null)
                findPath(node.rightNode, currentSum, expectSum, stack);
            currentSum -= node.value;
            stack.pop();
        }
    }

}


class Node{
    int value;
    Node leftNode;
    Node rightNode;

    public Node(int value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
    public Node(int value, Node leftNode, Node rightNode){
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
