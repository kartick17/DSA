package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTreeFromInorderPostorder extends BuildTree{

    Queue<BuildTree.Node> q = new LinkedList<>();
    int postIndex;
    BuildTreeFromInorderPostorder(int idx) {
        postIndex = idx-1;
    }
    int findPosition(int[] arr, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    Node buildTreeFromInorderPostorder(int[] inorder, int[] postorder, int start, int end) {
        // Base case
        if (postIndex < 0 || start > end)
            return null;

        // 1) Create root
        int data = postorder[postIndex--];
        Node node = new Node(data);
        int pos = findPosition(inorder, data, start, end);

        // 2) Right call
        node.right = buildTreeFromInorderPostorder(inorder, postorder, pos+1, end);

        // 3) Left call
        node.left = buildTreeFromInorderPostorder(inorder, postorder, start, pos-1);

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
//        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
//        int[] preorder = {1, 2, 4, 5, 3, 6, 7};

        int[] inorder = {4, 2, 7, 1, 5, 3, 6};
        int[] postorder = {4, 7, 2, 5, 6, 3, 1};
        BuildTreeFromInorderPostorder tree = new BuildTreeFromInorderPostorder(inorder.length);

        Node root = tree.buildTreeFromInorderPostorder(inorder, postorder, 0, inorder.length-1);
        tree.levelOrderTraverse(root);
    } 
}
