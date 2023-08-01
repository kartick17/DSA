package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBST extends BuildTree{

    Queue<Node> q = new LinkedList<>();
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

    void preOrder(Node root) {
        if (root == null) return;

        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
    }

    void inOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        inOrder(root.left);
        inOrder(root.right);
    }

    void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        PrintBST tree = new PrintBST();
        int[] node = {10, 20, 5, 11, 17, 2, 4, 8, 6, 25, 15, -1};
        Node root = tree.buildBST(node);
        System.out.println("Level order traversal");
        tree.levelOrderTraverse(root);
        System.out.println("\nPre order traversal");
        tree.preOrder(root);
        System.out.println("\nIn order traversal");
        tree.inOrder(root);
        System.out.println("\nPost order traversal");
        tree.postOrder(root);
    }
}
