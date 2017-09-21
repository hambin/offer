package data_struct.Tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by bing on 2017/9/12.
 */
public class OperatingOfTree {
    Node root = null;

    public static void main(String[] args){
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(3, node1, node2);
        Node node6 = new Node(7, node3, node4);
        Node root = new Node(5, node5, node6);

        OperatingOfTree operatingOfTree = new OperatingOfTree();
        System.out.println(operatingOfTree.isSymmetrical(root, root));
        operatingOfTree.printByRow(root);
        operatingOfTree.printByRev(root);
        System.out.println(operatingOfTree.kthNode(root, new int[]{3}).value);
    }

    //二叉树中序遍历的下一个节点，需要父节点，暂且搁置。
    public Node findNextNode(Node root){
        return null;
    }

    //判断是否为对称二叉树
    public boolean isSymmetrical(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.value != node2.value){
            return false;
        }

        return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
    }

    //把二叉树打印成多行
    public void printByRow(Node root){
        Node last = root, nLast = root;
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.left != null){
                queue.add(current.left);
                nLast = current.left;
            }
            if(current.right != null){
                queue.add(current.right);
                nLast = current.right;
            }
            System.out.print(current.value + " ");
            if(last == current){
                last = nLast;
                System.out.println();
            }
        }
    }

    //按"之"字形打印二叉树
    public void printByRev(Node root){
        Stack<Node>[] stacks = new Stack[2];
        int current = 0;
        int next = 1;
        stacks[current] = new Stack<>();
        stacks[next] = new Stack<>();
        stacks[current].push(root);
        while(!stacks[0].isEmpty() || !stacks[1].isEmpty()){
            Node currentNode = stacks[current].pop();
            System.out.print(currentNode.value + " ");
            if(current == 0){
                if(currentNode.left != null)
                    stacks[next].push(currentNode.left);
                if(currentNode.right != null)
                    stacks[next].push(currentNode.right);
            }else{
                if(currentNode.right != null)
                    stacks[next].push(currentNode.right);
                if(currentNode.left != null)
                    stacks[next].push(currentNode.left);
            }

            if(stacks[current].isEmpty()){
                System.out.println();
                current = 1-current;
                next = 1-next;
            }
        }
    }

    //为什么要用数组，因为需要引用传递，否则出错
    public Node kthNode(Node node, int[] k){
        return findKthNode(node, k);
    }
    public Node findKthNode(Node root, int[] k){
        if(root == null)
            return null;
        if(k[0] == 0)
            return null;
        Node target = null;
        if(root.left != null){
            target = findKthNode(root.left, k);
        }
        if(target == null){
            if(k[0] == 1){
                target = root;
            }
            k[0]--;
        }
        if(root.right != null && target == null){
            target = findKthNode(root.right, k);
        }
        return target;
    }


}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
