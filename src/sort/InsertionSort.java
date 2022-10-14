package sort;

public class InsertionSort {
    void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int idx = i - 1;
            while (idx >= 0 && arr[idx] > target) {
                arr[idx + 1] = arr[idx];
                idx--;
            }
            arr[idx + 1] = target;
        }
    }
}
