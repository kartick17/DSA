package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SumTree extends BuildTree{

    Queue<Node> q = new LinkedList<>();
    int sumTree(Node root) {
        if(root == null)
            return 0;

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        root.data = leftSum + root.data + rightSum;
        return root.data;
    }

    public static void main(String[] args) {
        SumTree tree = new SumTree();
        int[] node = {10, 20, 40, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, -1, -1};
        Node root = tree.buildTree(node);
        tree.sumTree(root);
        tree.levelOrderTraverse(root);
    }
}
