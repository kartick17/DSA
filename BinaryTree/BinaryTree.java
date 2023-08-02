package BinaryTree;

public class BinaryTree extends BuildTree{

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int node[] = {90, 20, 11, -1, -1,  13, -1, -1, 50, -1, -1};
        Node root = bt.buildTree(node);

        System.out.println(root.right.data);
    }
}
