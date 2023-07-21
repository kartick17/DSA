package Queue;

public class QueueInLL {

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  Node head = null, tail = null;
  void add(int data) {
    Node node = new Node(data);
    if (head == null) {
      head = tail = node;
      return;
    }
    tail.next = node;
    tail = node;
  }

  int remove() {
    if (head == null) {
      System.out.println("Empty queue");
      return -1;
    }
    int data = head.data;
    head = head.next;
    return data;
  }

  int peek() {
    if (head == null) {
      System.out.println("Empty queue");
      return -1;
    }
    return head.data;
  }

  boolean isEmpty() {
    return head == null;
  }

  public static void main(String[] args) {
    QueueInLL q = new QueueInLL();
    q.add(1);
    q.add(3);
    q.add(5);
    q.add(7);
    Node temp = q.head;
    while (temp != null) {
      System.out.println(temp.data + " ");
      temp = temp.next;
    }
  }
}
