package BinarySearchTree;

import java.util.Scanner;

public class SortedLLtoBST extends BuildBST{
    Node head = null, tail = null;

    void createLL(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        }
        tail.right = node;
        node.left = tail;
        tail = node;
    }

    void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.right;
        }
        System.out.println("null");
    }

    Node findMid(Node head, int mid) {
        mid = mid - 1;
        Node temp = head;
        while (mid-- > 0) {
            temp = temp.right;
        }
        return temp;
    }

//    Node bstUsingDLL(Node root, int n) {
//        if (root == null) return null;
//
//        int mid = n/2;
//        Node node = findMid(root, mid);
//        System.out.println(node.data);
//        Node nextHead = null;
//        if (node.left != null)
//            node.left.right = null;
//        if (node.right != null) {
//            nextHead = node.right;
//            nextHead.left = null;
//        }
//        if (node == head)
//            head = null;
//        node.left = bstUsingDLL(head, n-mid-1);
//        node.right = bstUsingDLL(nextHead, mid);
//        return node;
//    }

    Node bstUsingDLL(Node head, int n) {
        if (n <= 0 || head == null)
            return null;

        Node leftSubtree = bstUsingDLL(head, n-1-n/2);

        Node root = head;
        root.left = leftSubtree;
        head =head.right;
        root.right = bstUsingDLL(head, n/2);
        return root;
    }

    public static void main(String[] args) {
        SortedLLtoBST tree = new SortedLLtoBST();
        int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < data.length; i++) {
            tree.createLL(data[i]);
        }
        tree.printLL();
        tree.head.left = null;
        Node root = tree.bstUsingDLL(tree.head, data.length);
        System.out.println(root.left.data);
        tree.levelOrderTraverse(root);
    }
}
