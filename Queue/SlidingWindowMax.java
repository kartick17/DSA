package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
public class SlidingWindowMax {

    Deque<Integer> q = new LinkedList<>();
    Queue<Integer> maxQ = new LinkedList<>();

    void findMaximum(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();

            q.addLast(i);
        }
        maxQ.add(arr[q.peekFirst()]);

        for (int i = k; i < arr.length; i++) {
            if (!q.isEmpty() && i - k - q.peekFirst() >= 0)
                q.removeFirst();

            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();

            q.addLast(i);
            System.out.println(q);
            maxQ.add(arr[q.peekFirst()]);
        }
    }

    public static void main(String[] args) {
        SlidingWindowMax obj = new SlidingWindowMax();
        int arr[] = {1,3,1,2,0,5};
        obj.findMaximum(arr, 3);
        System.out.println(obj.maxQ);
    }
}