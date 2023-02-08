package sort;

public class HeapSort {
    static int[] heapSort(int[] arr) {
        buildHeap(arr);
        int len = arr.length;
        for (int i = len - 1; i > 1; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return arr;
    }

    static void buildHeap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2; i > 0; i--) {
            heapify(arr, i, len);
        }
    }

    static void heapify(int[] arr, int node, int heapSize) {
        int leftC = node * 2 + 1;
        int rightC = node * 2 + 2;
        int largest = node;
        if (leftC < heapSize && arr[leftC] > arr[largest]) {
            largest = leftC;
        }
        if (rightC < heapSize && arr[rightC] > arr[largest]) {
            largest = rightC;
        }
        if (largest != node) {
            swap(arr, node, largest);
            heapify(arr, largest, heapSize);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int m = 0;
        m = arr[a];
        arr[a] = b;
        arr[b] = m;
    }
}
