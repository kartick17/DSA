package Queue;

public class QueueInArray {

    int[] q = new int[10];
    int rear = -1;

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

    public int peek() {
        return q[0];
    }


    public static void main(String[] args) {
        QueueInArray q = new QueueInArray();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
