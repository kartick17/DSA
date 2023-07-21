package LinkedList;

import java.sql.SQLOutput;

public class ReverseLL {

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
    Node reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
        ReverseLL list = new ReverseLL();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.print();
        list.head = list.reverse();
        list.print();

    }
}
