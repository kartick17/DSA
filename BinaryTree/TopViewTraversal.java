package BinaryTree;

import java.util.*;

public class TopViewTraversal extends BuildTree {

    class Pair {
        Node root;
        int hd;
        Pair (Node root, int hd) {
            this.root = root;
            this.hd = hd;
        }
    }
    void printTopView(Node root) {
        // Create a map to store HD & node.data
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Queue<Pair> q = new LinkedList<>();

        // Create pair using pair class to store node and HD
        Pair p = new Pair(root, 0);
        q.add(p);

        while (!q.isEmpty()) {
            Pair pair = q.remove();

            // Check if current node hd is not include in map so include
            if (!hm.containsKey(pair.hd)) {
                hm.put(pair.hd, pair.root.data);
            }

            // Left node
            if (pair.root.left != null) {
                Pair left = new Pair(pair.root.left, pair.hd-1);
                q.add(left);
            }

            // Right node
            if (pair.root.right != null) {
                Pair right = new Pair(pair.root.right, pair.hd+1);
                q.add(right);
            }
        }

        // Printing keys and values
        for (Map.Entry<Integer, Integer> me : hm.entrySet()) {
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }
    }

    public static void main(String[] args) {
        TopViewTraversal tree = new TopViewTraversal();
        int[] node = {10, 20, 40, 80, -1, -1, 90, -1, -1, 50, 12, -1, -1, 15, -1, -1, 30, 60, -1, -1, 70, 23, -1, -1, 26, -1, -1};
        Node root = tree.buildTree(node);
        tree.printTopView(root);
    }
}
