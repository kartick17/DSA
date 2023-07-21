package BinaryTree;

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

    Node buildTree(int[] data, int idx) {
        if (data[idx] == -1)
            return null;

        Node node = new Node(data[idx]);
        node.left = buildTree(data, idx+1);
        node.right = buildTree(data, idx+1);

        return node;
    }
}
