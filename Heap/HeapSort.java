package Heap;

public class HeapSort extends BuildHeap {

    void heapSort(int[] arr, int size) {
        if (size < 1)
            return;

        int temp = arr[size];
        arr[size] = arr[1];
        arr[1] = temp;
        size--;
        heapify(arr, 1, size);
        heapSort(arr, size);
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        int arr[] = {-1, 50, 30, 70, 40, 80, 100};
        obj.buildHeap(arr, arr.length);
        obj.printHeap(arr);
        obj.heapSort(arr, arr.length-1);
        obj.printHeap(arr);
    }
}
