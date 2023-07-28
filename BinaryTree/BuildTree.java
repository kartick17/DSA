package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

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
    Queue<Node> q = new LinkedList<>();
    Node buildTree(int[] data) {
        idx++;
        if (data[idx] == -1)
            return null;

        Node node = new Node(data[idx]);
        node.left = buildTree(data);
        node.right = buildTree(data);

        return node;
    }

    Node buildTreeLevel(int[] data) {
        idx++;
        if (data[idx] == -1)
            return null;

        Node node = new Node(data[idx]);
        q.add(node);

        return node;
    }

}
