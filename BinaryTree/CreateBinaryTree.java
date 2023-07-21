package BinaryTree;

public class CreateBinaryTree extends BuildTree{

    public static void main(String[] args) {
        CreateBinaryTree bt = new CreateBinaryTree();
        int data[] = {90, 20, 11, -1, -1,  13, -1, -1, 50, -1, -1};
        BuildTree.Node root = bt.buildTree(data, 0);

        System.out.println(root.data);
    }
}
