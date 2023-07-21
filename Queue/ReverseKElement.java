package Queue;

import java.util.Stack;

public class ReverseKElement {
    int[] q;
    int front, rear, size;
    Stack<Integer> st = new Stack<>();
    int[] rq = new int[size];
    ReverseKElement(int n) {
        q = new int[n];
        front = rear = -1;
        size = n;
    }

    public boolean isEmpty() { return rear == -1; }

    public void add(int data) {
        if (rear == q.length -1) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1)
            front = 0;

        rear++;
        q[rear] = data;
    }

    void reverse(int k) {
        if (k < 0 && k > size)
            return;
        for (int i = 0; i < k; i++) {
            int data =  q[front];
            st.push(data);
            front++;
        }

        for (int i = 0; i < k; i++) {
            int data = st.pop();
            q[i] = data;
        }
    }

    void print() {
        for (int i = 0; i <= rear; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseKElement q = new ReverseKElement(10);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.print();
        q.reverse(5);
        q.print();
    }
}
