package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightViewTraversal extends BuildTree{

    void rightView(Node root, List<Integer> ans, int level) {
        if (root == null)
            return;

        if (ans.size() == level)
            ans.add(root.data);

        rightView(root.right, ans, level+1);
        rightView(root.left, ans, level+1);
    }

    public static void main(String[] args) {
        RightViewTraversal tree = new RightViewTraversal();
//        int node[] = {20, 30, 50, 55, -1, -1, -1, 40, -1, 60, -1, -1, 100, 90, -1, 105, -1, -1, 120, 110, -1, -1, 130, -1, -1};
        int[] node = {1, 2, 3, -1, -1, 4, 6, -1, -1, 8, -1, 9, -1, -1, 5, -1, 7, -1, -1};
        Node root = tree.buildTree(node);
        List<Integer> ans = new ArrayList<>();
        tree.rightView(root, ans, 0);
        System.out.println(ans);
    }
}
