package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal extends BuildTree {

    // Print Left Boundary
    void printLeftBoundary(Node root, List<Integer> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        ans.add(root.data);

        if (root.left != null)
            printLeftBoundary(root.left, ans);
        else
            printLeftBoundary(root.right, ans);
    }

    // Print Leaf Node
    void printLeaf(Node root, List<Integer> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }

        printLeaf(root.left, ans);
        printLeaf(root.right, ans);
    }

    // Print Right Boundary
    void printRightBoundary(Node root, List<Integer> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        if (root.right != null)
            printRightBoundary(root.right, ans);
        else
            printRightBoundary(root.left, ans);

        ans.add(root.data);
    }

    void boundaryTraversal(Node root, List<Integer> ans) {
        if (root == null)
            return;

        ans.add(root.data);
        printLeftBoundary(root.left, ans);
        printLeaf(root, ans);
        printRightBoundary(root.right, ans);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        BoundaryTraversal tree = new BoundaryTraversal();
//        int node[] = {20, 30, 50, 55, -1, -1, -1, 40, -1, 60, -1, -1, 100, 90, -1, 105, -1, -1, 120, 110, -1, -1, 130, -1, -1};
        int node[] = {1, 2, -1, 5, 7, 9, -1, -1, 8, -1, -1, 6, -1, -1, 4, -1, 10, -1, 12, 11, -1, -1, 13, -1, -1};
        List<Integer> ans = new ArrayList<>();
        Node root = tree.buildTree(node);
        tree.boundaryTraversal(root, ans);
    }
}
