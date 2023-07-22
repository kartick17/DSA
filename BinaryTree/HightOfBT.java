package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
public class HightOfBT extends BuildTree{

    Queue<Node> q = new LinkedList<>();

    int findHight(Node root) {
        if (root == null)
            return 0;

        int leftNode = findHight(root.left);
        int rightNode = findHight(root.right);

        return Math.max(leftNode, rightNode) + 1;
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
        HightOfBT tree = new HightOfBT();
        int[] node = {10, 20, 40, -1, -1, -1, 30, -1, 60, 70, 80, -1, -1, -1, -1};
        Node root = tree.buildTree(node);
        tree.levelOrderTraverse(root);
        int hight = tree.findHight(root);
        System.out.println("Hight of the tree is - " + hight);
    }
}
