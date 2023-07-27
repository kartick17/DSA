package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthAncestor extends BuildTree {

    Queue<Node> q = new LinkedList<>();
    int k = 2;
    boolean findAncestor(Node root, int p, int x) {
        if (root == null)
            return false;

        if (root.data == p)
            return true;

        boolean left = findAncestor(root.left, p, k);
        boolean right = findAncestor(root.right, p, k);

        if (left || right)
            k--;

        if (k == 0) {
            System.out.println(root.data);
            left = right = false;
        }

        return left || right;
    }

    void levelOrderTraverse(Node root) {
        Node empty = new Node(-1);
        if (root == null)
            return;

        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                System.out.println();
                if (!q.isEmpty())
                    q.add(null);
                continue;
            }

            System.out.print(temp.data + " ");

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        KthAncestor tree = new KthAncestor();
        int[] node = {10, 20, 40, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, -1, -1};
        Node root = tree.buildTree(node);
        tree.levelOrderTraverse(root);
        tree.findAncestor(root, 40, 1);
//        System.out.println(LCA.data);
    }
}


