package BinaryTree;

public class SearchNodeInBST extends BuildTree {

    boolean search (Node root, int target) {
        if (root == null)
            return false;

        if (root.data == target)
            return true;

        if (target < root.data)
            return search(root.left, target);
        else
            return search(root.right, target);
    }

    public static void main(String[] args) {
        SearchNodeInBST tree = new SearchNodeInBST();
        int[] node = {10, 20, 5, 11, 17, 2, 4, 8, 6, 25, 15, -1};
        Node root = tree.buildBST(node);
        boolean ans = tree.search(root, 5);
        System.out.println(ans);
    }
}
