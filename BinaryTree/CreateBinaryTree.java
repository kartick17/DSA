package BinaryTree;

public class CreateBinaryTree extends BuildTree{

    public static void main(String[] args) {
        CreateBinaryTree bt = new CreateBinaryTree();
        int node[] = {90, 20, 11, -1, -1,  13, -1, -1, 50, -1, -1};
        BuildTree.Node root = bt.buildTree(node);

        System.out.println(root.right.data);
    }
}
