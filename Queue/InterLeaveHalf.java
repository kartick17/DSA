package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class InterLeaveHalf {
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> hq = new LinkedList<>();
    void interleaveQueue() {
        int size = q.size();
        if (size < 3) return;

        int half = (size+1)/2;
        for (int i = 0; i < half; i++) {
            int data = q.remove();
            hq.add(data);
        }

        half = q.size();
        for (int i = 0; i < half; i++) {
            q.add(hq.remove());
            q.add(q.remove());
        }
        if (!hq.isEmpty())
            q.add(hq.remove());
    }

    public static void main(String[] args) {
        InterLeaveHalf obj = new InterLeaveHalf();
        obj.q.add(1);
        obj.q.add(2);
        obj.q.add(3);
        obj.q.add(4);
        obj.q.add(5);
        obj.q.add(6);
        obj.q.add(7);
        obj.q.add(8);
        System.out.println(obj.q);
        obj.interleaveQueue();
        System.out.println(obj.q);
    }
}
