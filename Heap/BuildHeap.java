package Heap;

import BinaryTree.BuildTree;

public class BuildHeap {

    void heapify(int[] heap, int i, int len) {
        int max = i, left = 2*i, right = 2*i+1;
        if (left < len && heap[left] > heap[max])
            max = left;

        if (right < len && heap[right] > heap[max])
            max = right;

        if (max != i) {
            int temp = heap[max];
            heap[max] = heap[i];
            heap[i] = temp;
            heapify(heap, max, len);
        }
    }

    void heapifyMin(int[] heap, int i, int len) {
        int min = i, left = i*2, right = i*2+1;
        if (left < len && heap[left] < heap[min])
            min = left;

        if (right < len && heap[right] < heap[min])
            min = right;

        if (min != i) {
            int temp = heap[min];
            heap[min] = heap[i];
            heap[i] = temp;
            heapify(heap, min, len);
        }
    }

    void buildHeap(int[] arr, int n) {
        for (int i = n/2; i > 0; i--) {
            heapify(arr, i, n);
        }
    }

    void buildHeapMin(int[] arr, int len) {
        for (int i = len/2; i > 0; i--)
            heapifyMin(arr, i, len);
    }

    void printHeap(int[] heap){
        System.out.println("Print heap");
        for (int i = 1; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

}
