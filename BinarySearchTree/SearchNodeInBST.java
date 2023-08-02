package BinarySearchTree;

import BinaryTree.BuildTree;

public class SearchNodeInBST extends BuildBST{

    Node search (Node root, int target) {
        if (root == null)
            return root;

        if (root.data == target) {
            return root;
        }

        if (target < root.data)
            return search(root.left, target);
        else
            return search(root.right, target);
    }

    int minValue(Node root) {
        if (root == null)
            return -1;
        Node temp = root;
        while (temp.left != null)
            temp = temp.left;

        return temp.data;
    }

    int maxValue(Node root) {
        if (root == null)
            return -1;
        Node temp = root;
        while(temp.right != null)
            temp = temp.right;

        return temp.data;
    }

    public static void main(String[] args) {
        SearchNodeInBST tree = new SearchNodeInBST();
        int[] node = {10, 20, 5, 11, 17, 2, 4, 8, 6, 25, 15, 35, 1, -1};
        Node root = tree.buildBST(node);
        Node ans = tree.search(root, 5);
        System.out.println(ans.data);
        System.out.println("Minimum value is - " + tree.minValue(root));
        System.out.println("Maximum value is - " + tree.maxValue(root));
    }
}
