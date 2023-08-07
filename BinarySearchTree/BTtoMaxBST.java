package BinarySearchTree;

import BinaryTree.BuildTree;

public class BTtoMaxBST extends BuildTree {

    class NodeData {
        int size, max, min;
        NodeData(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }

        NodeData() {
        }
    }

    NodeData findMaxBST(Node root) {

        if (root == null) {
            return new NodeData(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        NodeData left = findMaxBST(root.left);
        NodeData right = findMaxBST(root.right);

        if (root.data > left.max && root.data < right.min) {
            return new NodeData(left.size + right.size + 1, Math.min(root.data, left.min), Math.max(root.data, right.max));
        }

        return new NodeData(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        BTtoMaxBST tree = new BTtoMaxBST();
//        int[] node = {30, 10, 50, 15, 25, 45, 60, 10, 18, 22, 28, 40, 48, 52, -1};
        int[] node = {20, 15, 40, 14, 18, 30, 60, -1, 17, 10, 19, -1, -1, 50, -1};
        Node root = tree.buildTreeLevel(node);
        NodeData ans = tree.findMaxBST(root);
        System.out.println(ans.size);
    }

}
