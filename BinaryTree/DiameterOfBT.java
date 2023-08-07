package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBT extends BuildTree {

    Queue<Node> q = new LinkedList<>();

    int findHight(Node root) {
        if (root == null)
            return 0;

        int leftNode = findHight(root.left);
        int rightNode = findHight(root.right);

        return Math.max(leftNode, rightNode) + 1;
    }

    int findDiameter(Node root) {
        if (root == null)
            return 0;

        int op1 = findDiameter(root.left);
        int op2 = findDiameter(root.right);
        int op3 = findHight(root.left) + findHight(root.right);

        int ans = Math.max(op1, Math.max(op2, op3));
        return ans;
    }

    public static void main(String[] args) {
        DiameterOfBT tree = new DiameterOfBT();
        int[] node = {10, 20, -1, -1, 30,  40, 55, -1, -1, -1, 60, 70, 80, -1, -1, -1, -1};
        Node root = tree.buildTree(node);
        tree.levelOrderTraverse(root);
        int diameter = tree.findDiameter(root);
        System.out.println("Diameter of the tree is - " + diameter);
    }
}
