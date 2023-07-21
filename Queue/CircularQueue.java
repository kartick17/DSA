package Queue;

public class CircularQueue {
    int[] q = new int[5];
    int front = -1, rear = -1;
    int size = q.length;

    boolean isFull() {
        return (rear+1)%size == front;
    }

    boolean isEmpty() {
        return front == -1 && rear == -1;
    }
    void add(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if (front == -1) {
            front++;
        }
        rear = (rear+1)%size;
        q[rear] = data;
    }

    int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int data = q[front];
        if (front == rear) {
            front = rear = -1;
            return data;
        }
        front = (front+1)%size;
        return data;
    }

    int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return q[front];
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue();
        cq.add(2);
        cq.add(4);
        cq.add(6);
        cq.add(8);
        cq.add(1);
        cq.add(3);
        while (!cq.isEmpty()) {
            System.out.println(cq.peek() + " ");
            cq.remove();
        }
    }
}
