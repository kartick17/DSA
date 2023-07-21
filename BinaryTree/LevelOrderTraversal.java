package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal extends BuildTree{
    Queue<Node> q = new LinkedList<>();

    void traverseTree(Node root) {
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

    void printTree(Node root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.data + " ");

        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();

        int node[] = {20, 30, 50, 55, -1, -1, -1, 40, -1, 60, -1, -1, 100, 90, -1, 105, -1, -1, 120, 110, -1, -1, -1};
        BuildTree.Node root = tree.buildTree(node);
        tree.printTree(root);
        System.out.println();
        tree.traverseTree(root);
    }
}
