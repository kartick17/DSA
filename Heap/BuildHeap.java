package Heap;

import BinaryTree.BuildTree;

public class BuildHeap {

    void heapify(int[] heap, int i, int n) {
        int max = i, left = 2*i, right = 2*i+1;
        if (left < n && heap[left] > heap[max])
            max = left;

        if (right < n && heap[right] > heap[max])
            max = right;

        if (max != i) {
            int temp = heap[max];
            heap[max] = heap[i];
            heap[i] = temp;
            heapify(heap, max, n);
        }
    }

    void buildHeap(int[] arr, int n) {
        for (int i = n/2; i > 0; i--) {
            heapify(arr, i, n);
        }
    }

    void printHeap(int[] heap){
        System.out.println("\nPrint heap");
        for (int i = 1; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
    }

}
