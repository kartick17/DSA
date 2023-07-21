package LinkedList;

public class ReverseKNode {

    class Node {

        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
    Node head = null;
    Node tail = null;

    void insert(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    Node reverseKNode(Node head, int k) {
        if (head == null) return null;

        // Base case
        int len = count(head);
        if (k > len) {
            return head;
        }

        // Reverse first K node
        Node prev = null;
        Node curr = head;
        Node nxt = curr.next;
        int cnt = 0;
        while (cnt < k) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            cnt++;
        }

        // Recursive call and set current head next to recursive ans
        Node ans = reverseKNode(nxt, k);
        head.next = ans;

        // return prev node as previous node
        return prev;
    }

    int count(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseKNode list = new ReverseKNode();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.print();
        list.head = list.reverseKNode(list.head, 3);
        list.print();

    }
}
