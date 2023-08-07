package BinarySearchTree;

import BinaryTree.BuildTree;

public class CheckValidBST extends BuildTree {

    int calculateNode(Node root) {
        if (root == null)
            return 0;

        int left = calculateNode(root.left);
        int right = calculateNode(root.right);
        return left + right + 1;
    }
    int maxValidBST(Node root) {
        if (root == null)
            return 0;

        boolean valid = checkBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (valid == true) {
            return calculateNode(root);
        }

        int leftAns = maxValidBST(root.left);
        int rightAns = maxValidBST(root.right);
        return Math.max(leftAns, rightAns);
    }

    boolean checkBinaryTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (min > root.data || max < root.data)
            return false;

        boolean leftAns = checkBinaryTree(root.left, min, root.data);
        boolean rightAns = checkBinaryTree(root.right, root.data, max);

        return leftAns && rightAns;
    }

    public static void main(String[] args) {
        CheckValidBST tree = new CheckValidBST();
        int[] node = {30, 20, 50, 15, 25, 45, 60, 10, 18, 22, 28, 40, 48, 52, -1};
        Node root = tree.buildTreeLevel(node);
        int maxNode = tree.maxValidBST(root);
        System.out.println(maxNode);
    }
}
