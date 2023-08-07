package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
public class HightOfBT extends BuildTree{

    Queue<Node> q = new LinkedList<>();

    int findHight(Node root) {
        if (root == null)
            return 0;

        int leftNode = findHight(root.left);
        int rightNode = findHight(root.right);

        return Math.max(leftNode, rightNode) + 1;
    }

    public static void main(String[] args) {
        HightOfBT tree = new HightOfBT();
        int[] node = {10, 20, 40, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, -1, -1};
        Node root = tree.buildTree(node);
        tree.levelOrderTraverse(root);
        int hight = tree.findHight(root);
        System.out.println("Hight of the tree is - " + hight);
    }
}
