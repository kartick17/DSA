package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SumTree extends BuildTree{

    Queue<Node> q = new LinkedList<>();
    int sumTree(Node root) {
        if(root == null)
            return 0;

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        root.data = leftSum + root.data + rightSum;
        return root.data;
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
        SumTree tree = new SumTree();
        int[] node = {10, 20, 40, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, -1, -1};
        Node root = tree.buildTree(node);
        tree.sumTree(root);
        tree.levelOrderTraverse(root);
    }
}
