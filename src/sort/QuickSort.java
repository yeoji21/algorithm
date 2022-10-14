package sort;

public class QuickSort {
    void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right;

        while (i < j) {
            while(pivot < arr[j]) j--;
            while(i < j && pivot >= arr[i]) i++;

            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }
}
