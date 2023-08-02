package BinarySearchTree;

public class DeleteNodeInBST extends BuildBST{
    int findMin(Node root) {
        if (root.left == null)
            return root.data;
        int min = findMin(root.left);
        return min;
    }

    Node deleteNode(Node root, int target) {
        if (root == null) return null;

        if (root.data == target) {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                int inorederSuccessor = findMin(root.right);
                root.data = inorederSuccessor;
                root.right = deleteNode(root.right, inorederSuccessor);
                return root;
            }
        }
        else if (target < root.data) {
            root.left = deleteNode(root.left, target);
        }
        else if (target > root.data) {
            root.right = deleteNode(root.right, target);
        }
        return root;
    }

    public static void main(String[] args) {
        DeleteNodeInBST obj = new DeleteNodeInBST();
        int[] data = {10, 6, 20, 4, 8, 16, 25, 2, 7, 14, 18, 22, 21, -1};
        Node root = obj.buildBST(data);
        obj.levelOrderTraverse(root);
        obj.deleteNode(root, 10);
        obj.levelOrderTraverse(root);
    }
}
