package data_struct;

/**
 * Created by bing on 2017/9/6.
 */
public class TreeByLink {

    public static void main(String[] args){
        int[] datas = new int[]{6,3,5,9,7,8,4,2};
        BinaryTree binaryTree = new BinaryTree();
        for(int i = 0; i < datas.length; i++){
            binaryTree.addNodeToTree(datas[i]);
        }
        binaryTree.printTree(binaryTree.rootNode);

    }

}

class TreeNode{
    int value;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
}

class BinaryTree{
    public TreeNode rootNode;

//    public BinaryTree(int[] datas){
//        for(int i = 0; i < datas.length; i++){
//            addNodeToTree(datas[i]);
//        }
//
//    }

    public void addNodeToTree(int value){
        if(rootNode == null){
            rootNode = new TreeNode(value);
            return;
        }
        TreeNode currentNode = rootNode;
        while(true){
            //left subTree
            if(currentNode.value > value){
                if(currentNode.leftNode == null){
                    currentNode.leftNode = new TreeNode(value);
                    return;
                }else{
                    currentNode = currentNode.leftNode;
                }
            }else{
                if(currentNode.rightNode == null){
                    currentNode.rightNode = new TreeNode(value);
                    return;
                }else{
                    currentNode = currentNode.rightNode;
                }
            }
        }
    }


    public void printTree(TreeNode rootNode){
        if(rootNode != null){
            printTree(rootNode.leftNode);
            System.out.print(rootNode.value + "--");
            printTree(rootNode.rightNode);
        }
    }
}
