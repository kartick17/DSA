package BinarySearchTree;

import BinaryTree.BuildTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildBST {

    class Node {
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
            left = null;
            right = null;
        }
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

    void levelOrderTraverse(Node root) {
        Queue<Node> q = new LinkedList<>();
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
