package Heap;

import java.util.Scanner;

public class InsertNodeInHeap extends BuildHeap{

    int size = 0;
    int heap[];
    public InsertNodeInHeap(int data) {
        heap = new int[data];
    }

    void insertNode(int data) {
        int child = ++size;
        heap[child] = data;
        int parent = child/2;

        while (parent > 0 && heap[child] > heap[parent]) {
            int temp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = temp;

            child = parent;
            parent = parent/2;
        }
    }

    void deleteNode() {
        heap[1] = heap[size--];
        int parent = 1;
        int max = parent;

        while (parent <= size) {
            int left = 2 * parent, right = 2 * parent + 1;
            if (left <= size && heap[left] > heap[max]) {
                max = left;
            }
            if (right <= size && heap[right] > heap[max]) {
                max = right;
            }

            if (max != parent) {
                int temp = heap[max];
                heap[max] = heap[parent];
                heap[parent] = temp;

                parent = max;
            }
            else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        InsertNodeInHeap obj = new InsertNodeInHeap(10);
        obj.insertNode(100);
        obj.insertNode(50);
        obj.insertNode(60);
        obj.insertNode(40);
        obj.insertNode(45);
        obj.insertNode(53);
        obj.insertNode(52);

        obj.printHeap(obj.heap);
        obj.heapify(obj.heap, 1, obj.size);
        obj.printHeap(obj.heap);
    }
}
