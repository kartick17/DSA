package Queue;

import java.util.Stack;

public class ReverseQueue {

    int[] q;
    int front, rear, size;
    Stack<Integer> st = new Stack<>();
    ReverseQueue(int n) {
        q = new int[n];
        front = rear = -1;
        size = n;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public void add(int data) {
        if (rear == q.length -1) {
            System.out.println("Queue is full");
            return;
        }

        rear++;
        q[rear] = data;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }

        int front = q[0];
        for (int i = 0; i < rear; i++) {
            q[i] = q[i+1];
        }
        rear--;
        return front;
    }

    // Reverse queue using recursion
//    void reverse() {
//        if (isEmpty()) return;
//
//        int data = remove();
//        reverse();
//        add(data);
//    }

    // Reverse queue using stack
    void reverse() {
        while (!isEmpty()) {
            int data = remove();
            st.push(data);
        }

        while (!st.empty()) {
            int data = st.pop();
            add(data);
        }
    }

    void print() {
        for (int i = 0; i <= rear; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseQueue q = new ReverseQueue(10);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.print();
        q.reverse();
        q.print();
    }
}
