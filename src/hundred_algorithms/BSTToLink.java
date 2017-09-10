package hundred_algorithms;

/**
 * Created by bing on 2017/9/5.
 * 输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。
 *要求不能创建任何新的结点，只调整指针的指向。
 */
public class BSTToLink {
    public static class Node{
        private int value;
        private Node leftNode;
        private Node rightNode;

        public Node(int value, Node leftNode, Node rightNode){
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    private static Node head, tail;

    public static void traversal(Node node){
        if(node == null)
            return;

        if(node.leftNode != null)
            traversal(node.leftNode);
        changePoint(node);
        if(node.rightNode != null)
            traversal(node.rightNode);
    }

    public static void changePoint(Node node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.leftNode = tail;
            tail.rightNode = node;
            tail = node;
        }
    }

    public static void printHead(){
        while(head != null){
            System.out.print(head.value + " ");
            head = head.rightNode;
        }
    }

    public static void printTail(){
        while(tail != null){
            System.out.print(tail.value + " ");
            tail = tail.leftNode;
        }
    }

    public static void main(String[] args){
        Node node1 = new Node(4, null, null);
        Node node2 = new Node(8,null,null);
        Node node3= new Node(12,null,null);
        Node node4 = new Node(16,null,null);
        Node node5 = new Node(6, node1, node2);
        Node node6 = new Node(14,node3,node4);
        Node node7 = new Node(10, node5, node6);

        traversal(node7);
        printHead();
        System.out.println();
        printTail();
    }
}
