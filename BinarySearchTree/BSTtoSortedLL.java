package BinarySearchTree;

public class BSTtoSortedLL extends BuildBST {

    Node head = null;
    Node convertToLL(Node root) {
        if (root == null)  return head;

        convertToLL(root.right);

        root.right = head;
        if (head != null)
            head.left = root;
        head = root;
        convertToLL(root.left);
        return head;
    }

    public static void main(String[] args) {
        BSTtoSortedLL tree = new BSTtoSortedLL();
        int data[] = {50, 25, 60, 10, 40, 54, 70, 30, 56, 65, -1};
        Node root = tree.buildBST(data);
        tree.levelOrderTraverse(root);
        Node head = tree.convertToLL(root);
        Node tail = head;
        while (head != null) {
            System.out.print(head.data + " -> ");
            tail = head;
            head = head.right;
        }
        System.out.println("null");

        while (tail != null) {
            System.out.print(tail.data + " -> ");
            tail = tail.left;
        }
        System.out.println("null");
    }
}
