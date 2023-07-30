package BinaryTree;

import java.util.Stack;

public class ZigzagTraversal extends BuildTree {

    Stack<Node> even = new Stack<>();
    Stack<Node> odd = new Stack<>();
    void zigzagReverseOrderTraverse(Node root) {
        if (root == null)
            return;

        even.push(root);
        int level = 0;

        while (!even.isEmpty() || !odd.isEmpty()) {
//            System.out.println(level);
            if (level%2 == 1 ) {
                Node temp = odd.pop();
                System.out.print(temp.data + " " );

                if (temp.left != null)
                    even.push(temp.left);

                if (temp.right != null)
                    even.push(temp.right);

                if (odd .isEmpty()) level++;
            }
            else if (level%2 == 0){
                Node temp = even.pop();
                System.out.print(temp.data + " ");

                if (temp.right != null)
                    odd.push(temp.right);

                if (temp.left != null)
                    odd.push(temp.left);

                if (even.isEmpty()) level++;
            }
        }
    }

    void zigzagOrderTraverse(Node root) {
        if (root == null)
            return;

        even.push(root);
        int level = 0;

        while (!even.isEmpty() || !odd.isEmpty()) {
//            System.out.println(level);
            if (level%2 == 1 ) {
                Node temp = odd.pop();
                System.out.print(temp.data + " " );

                if (temp.right != null)
                    even.push(temp.right);

                if (temp.left != null)
                    even.push(temp.left);

                if (odd .isEmpty()) level++;
            }
            else if (level%2 == 0){
                Node temp = even.pop();
                System.out.print(temp.data + " ");

                if (temp.left != null)
                    odd.push(temp.left);

                if (temp.right != null)
                    odd.push(temp.right);

                if (even.isEmpty()) level++;
            }
        }
    }

    public static void main(String[] args) {
        ZigzagTraversal tree = new ZigzagTraversal();
        int[] node = {10, 20, 40, 80, -1, -1, 90, -1, -1, 50, 12, -1, -1, 15, -1, -1, 30, 60, -1, -1, 70, 23, -1, -1, 26, -1, -1};
        Node root = tree.buildTree(node);
        System.out.print("Zigzag order traversal: ");
        tree.zigzagOrderTraverse(root);
        System.out.println();

        System.out.print("Zigzag reverse order traversal: ");
        tree.zigzagReverseOrderTraverse(root);
        System.out.println();
    }
}
