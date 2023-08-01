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

    Node createBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = createBST(root.left, data);
        else {
            root.right = createBST(root.right, data);
        }
        return root;
    }

    Node buildBST(int[] data) {
        int index = 0;
        if (data[index] == -1)
            return null;

        Node root = null;
        while (data[index] != -1 && index < data.length) {
            root = createBST(root, data[index]);
            index++;
        }
        return root;
    }

}
