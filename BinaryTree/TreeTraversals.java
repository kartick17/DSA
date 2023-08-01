package BinaryTree;

import java.util.*;

public class TreeTraversals extends BuildTree{
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

    void levelOrderBottom(Node root, List<Integer> list, List<List<Integer>> lists) {
        if (root == null)
            return;

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.remove();

            if (temp == null) {
                lists.add(0, new ArrayList<Integer>(list));
                list = new ArrayList<>();
                if (!q.isEmpty())
                    q.add(null);
                continue;
            }
            list.add(temp.data);

            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);

        }
    }

    void inOrderTravers(Node root) {
        if (root == null)
            return;

        inOrderTravers(root.left);
        System.out.print(root.data + " ");
        inOrderTravers(root.right);
    }

    void preOrderTraverse(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    void postOrderTraverse(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        TreeTraversals tree = new TreeTraversals();

        int node[] = {20, 30, 50, 55, -1, -1, -1, 40, -1, 60, -1, -1, 100, 90, -1, 105, -1, -1, 120, 110, -1, -1, 130, -1, -1};
        int levelNode[] = {1, 2, 3, 4, -1, 5, 6, 7, 8, -1, -1, 9, 10, -1, -1, -1, -1, -1, -1, -1, -1};
//        Node root = tree.buildTree(node);
        System.out.println("Level Order Traversal");
//        tree.levelOrderTraverse(root);
//        System.out.println("\nPreorder Traversal");
//        tree.preOrderTraverse(root);
//        System.out.println();
//        System.out.println("\nInorder Traversal");
//        tree.inOrderTravers(root);
//        System.out.println();
//        System.out.println("\nPostorder Traversal");
//        tree.postOrderTraverse(root);

//        System.out.println("Level order bottom traversal");
//        List<List<Integer>> lists = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        tree.levelOrderBottom(root, list, lists);
//        System.out.println(lists);
        Node rootLevel = tree.buildTreeLevel(levelNode);
        tree.levelOrderTraverse(rootLevel);

    }
}
