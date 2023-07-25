package BinaryTree;

public class KthAncestor extends BuildTree {

    Node findAncestor(Node root, int p, int k) {
        if (root == null)
            return null;

        Node left = findAncestor(root.left, p, k);
        Node right = findAncestor(root.right, p, k);

        if (left.data == p || right.data == p)
            k--;

        if (k == 0)
            return root;
        return null;
    }

    public static void main(String[] args) {
        KthAncestor tree = new KthAncestor();
        int[] node = {10, 20, 40, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, -1, -1};
        Node root = tree.buildTree(node);
        Node LCA = tree.findAncestor(root, 40, 1);
        System.out.println(LCA.data);
    }
}
