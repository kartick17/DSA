package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTreeFromInorderPreorder extends BuildTree {

    Queue<Node> q = new LinkedList<>();
    int preIndex = 0;
    int findPosition(int[] arr, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    Node buildTreeFromInorderPreorder(int[] inorder, int[] preorder, int start, int end) {
        // Base case
        if (preIndex >= preorder.length || start > end)
            return null;

        // 1) Create root
        int data = preorder[preIndex++];
        Node node = new Node(data);
        int pos = findPosition(inorder, data, start, end);

        // 2) Left call
        node.left = buildTreeFromInorderPreorder(inorder, preorder, start, pos-1);

        // 3) Right call
        node.right = buildTreeFromInorderPreorder(inorder, preorder, pos+1, end);

        return node;
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

    public static void main(String[] args) {
        BuildTreeFromInorderPreorder tree = new BuildTreeFromInorderPreorder();
//        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
//        int[] preorder = {1, 2, 4, 5, 3, 6, 7};

        int[] inorder = {2, 1, 4, 3, 5};
        int[] preorder = {1, 2, 3, 4, 5};

        Node root = tree.buildTreeFromInorderPreorder(inorder, preorder, 0, inorder.length);
        tree.levelOrderTraverse(root);
    }
}
