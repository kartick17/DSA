package BinaryTree;

public class LowestCommonAncestor extends BuildTree{

    Node findLCM(Node root, Node p, Node q) {

        if (root == null || root == p || root == q)
            return root;

        Node left = findLCM(root.left, p, q);
        Node right = findLCM(root.right, p, q);

        if (left == null && right == null)
            return null;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        else
            return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        int[] node = {10, 20, 40, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, -1, -1};
        Node root = tree.buildTree(node);
        Node LCA = tree.findLCM(root, root.left.left, root.left.right);
        System.out.println(LCA.data);
    }
}
