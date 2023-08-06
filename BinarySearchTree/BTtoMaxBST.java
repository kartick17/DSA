package BinarySearchTree;

import BinaryTree.BuildTree;

public class BTtoMaxBST extends BuildTree {

    class NodeData {
        int size, max, min;
        boolean valid;
        NodeData(int size, int min, int max, boolean valid) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.valid = valid;
        }

        NodeData() {
        }
    }

    NodeData findMaxBST(Node root, int ans) {

        if (root == null) {
            NodeData curr = new NodeData(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return curr;
        }
        NodeData curr = new NodeData();
        NodeData left = findMaxBST(root.left, ans);
        NodeData right = findMaxBST(root.right, ans);

        curr.size = left.size + right.size + 1;
        curr.min = Math.min(left.min, root.data);
        curr.max = Math.max(right.max, root.data);
        curr.valid = false;

        return curr;
    }



}
