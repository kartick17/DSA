package BinaryTree;

import java.util.*;

public class BottomViewTraversal extends BuildTree {
    class Pair {
        int hd;
        Node root;
        Pair(Node root, int hd) {
            this.root = root;
            this.hd = hd;
        }
    }

    void levelOrderTraverse(Node root) {
        Queue<Node> q = new LinkedList<>();
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

    HashMap<Integer, Integer> bottomView(Node root) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        if (root == null)
            return hm;

        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(root, 0);
        q.add(pair);

        while (!q.isEmpty()) {
            Pair p = q.remove();
            hm.put(p.hd, p.root.data);

            if (p.root.left != null) {
                Pair left = new Pair(p.root.left, p.hd-1);
                q.add(left);
            }

            if (p.root.right != null) {
                Pair right = new Pair(p.root.right, p.hd+1);
                q.add(right);
            }
        }
        return hm;
    }

    public static void main(String[] args) {
        BottomViewTraversal tree = new BottomViewTraversal();
        int node[] = {20, 30, 50, 55, -1, -1, -1, 40, -1, 60, -1, -1, 100, 90, -1, 105, -1, -1, 120, 110, -1, -1, 130, -1, -1};
        Node root = tree.buildTree(node);
        tree.levelOrderTraverse(root);
        HashMap<Integer, Integer> hm = tree.bottomView(root);
        System.out.println(hm);
    }
}
