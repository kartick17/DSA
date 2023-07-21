package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegetiveNumber {

    Queue<Integer> nq = new LinkedList<>();
    Queue<Integer> q = new LinkedList<>();

    void findNegative(int[] arr, int k) {

        // Check first k element
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0)
                nq.add(i);
        }
        if (!nq.isEmpty())
            q.add(arr[nq.peek()]);
        else
            q.add(0);

        System.out.println(nq);

        // Check after k element
        for (int i = k; i < arr.length; i++) {

            // If nq have extra element so remove
            if (!nq.isEmpty() && i-nq.peek()-k >= 0)
                nq.remove();

            // Push negative number to nq
            if (arr[i] < 0)
                nq.add(i);

            System.out.println(nq);
            // Get first negative number from ng is it have
            if (!nq.isEmpty())
                q.add(arr[nq.peek()]);
            else
                q.add(0);
        }
    }

    public static void main(String[] args) {
        FirstNegetiveNumber obj = new FirstNegetiveNumber();
        int arr[] = {1, 2, 12, -1, -6, 8, -10, 10, 20, 22};
        obj.findNegative(arr, 3);
        System.out.println(obj.q);
    }
}
