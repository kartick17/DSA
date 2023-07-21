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

    int idx = -1;
    Node buildTree(int[] data) {
        idx++;
        if (data[idx] == -1)
            return null;

        Node node = new Node(data[idx]);
        node.left = buildTree(data);
        node.right = buildTree(data);

        return node;
    }
}
