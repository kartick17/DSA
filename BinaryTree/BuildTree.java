package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {

    class Node {
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    int idx = -1;
    Queue<Node> q = new LinkedList<>();
    Node buildTree(int[] data) {
        idx++;
        if (data[idx] == -1)
            return null;

        Node node = new Node(data[idx]);
        node.left = buildTree(data);
        node.right = buildTree(data);

        return node;
    }

    Node buildTreeLevel(int[] data) {
        idx = 0;
        Node node = new Node(data[idx]);
        Node n = node;
        q.add(node);

        while (!q.isEmpty() && idx < data.length) {
            Node root = q.remove();
            if (++idx < data.length) {
                if (data[idx] == -1)
                    node = null;
                else {
                    node = new Node(data[idx]);
                    q.add(node);
                }
                root.left = node;
            }
            if (++idx < data.length) {
                if (data[idx] == -1)
                    node = null;
                else {
                    node = new Node(data[idx]);
                    q.add(node);
                }
                root.right = node;
            }
        }
        return n;
    }

    void levelOrderTraverse(Node root) {
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

}
