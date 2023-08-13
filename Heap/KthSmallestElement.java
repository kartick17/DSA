package Heap;

public class KthSmallestElement extends BuildHeap {

    // Using min heap
    int kSmallestElement(int[] arr, int k, int len) {
        if (k >= arr.length)
            return -1;

//        buildHeapMin(arr, arr.length);
//        printHeap(arr);
//
//        int i = 0, ans = -1;
//        while (i < k) {
//            ans = arr[1];
//            arr[1] = --len;
//            heapifyMin(arr, 1, len);
//            printHeap(arr);
//            i++;
//        }
//        return ans;

        buildHeap(arr, k+1);
        printHeap(arr);

        for (int i = k+1; i < arr.length; i++) {
            if (arr[i] < arr[1]) {
                arr[1] = arr[i];
                heapify(arr, 1, k+1);
            }
        }
        return arr[1];
    }


    public static void main(String[] args) {
        KthSmallestElement obj = new KthSmallestElement();
//        int arr[] = {-1, 3, 11, 6, 9, 4, 12, 2, 8};
        int[] arr = {-1, 10, 8, 70, 90, 4, 60, 1};
        obj.buildHeapMin(arr, arr.length);
        int ans = obj.kSmallestElement(arr, 4, arr.length);
        System.out.println(ans);
    }

}
