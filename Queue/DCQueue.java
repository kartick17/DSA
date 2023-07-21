package Queue;

public class DCQueue {

    int[] q = new int[10];
    int front = -1, rear = -1, size = q.length;

    boolean isFull() {
        return (rear+1)%size == front;
    }

    boolean isEmpty() {
        return front == -1;
    }
    void addRear(int data) {
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

    void addFront(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (rear == -1 && front == -1) {
            front = rear = size-1;
        }
        else {
            front = (front + size - 1) % size;
        }
        q[front] = data;
    }

    int removeRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int data = q[rear];
        q[rear] = -1;
        if (front == rear) {
            front = rear = -1;
            return data;
        }
        rear = (rear + size - 1) % size;
        return data;
    }

    int removeFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int data = q[front];
        q[front] = -1;
        if (front == rear) {
            front = rear = -1;
            return data;
        }
        front = (front+1)%size;
        return data;
    }

    void peekRear() {
        System.out.println("Rear = " + q[rear]);
    }

    void peekFront() {
        System.out.println("Front = " + q[front]);
    }

    void print() {
        int i = 0;
        while (i < size) {
            System.out.print(q[i] + " ");
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DCQueue dq = new DCQueue();
        dq.addFront(5);
        dq.addRear(1);
        dq.addRear(2);
        dq.addRear(3);
        dq.addRear(4);
        dq.addFront(6);
        dq.addFront(7);
        dq.addFront(8);
        dq.addRear(10);
        dq.addRear(12);
        dq.print();
        dq.removeFront();
        dq.print();
        dq.removeFront();
        dq.print();
        dq.removeRear();
        dq.print();
        dq.removeFront();
        dq.print();
        dq.removeFront();
        dq.print();
        dq.removeFront();
        dq.print();
        dq.removeFront();
        dq.print();
        dq.addRear(3);
        dq.print();
        dq.addRear(4);
        dq.print();
        dq.addFront(6);
        dq.print();
        dq.addRear(15);
        dq.print();
        dq.addRear(20);
        dq.print();
        dq.addRear(25);
        dq.print();
        dq.addRear(30);
        dq.print();
//        dq.removeRear();
//        dq.print();
//        dq.removeFront();
//        dq.print();

        int i = dq.front;
        while (i != dq.rear) {
            System.out.print(dq.q[i] + " ");
            i = (i + 1) % dq.size;
        }
        System.out.println(dq.q[i]);
    }
}
