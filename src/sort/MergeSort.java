package sort;

import java.util.Arrays;

public class MergeSort {
    void mergeSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        int ll = L.length, rl = R.length;

        while (i < ll && j < rl) {
            if(L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while (i < ll) {
            arr[k++] = L[i++];
        }
        while (j < rl) {
            arr[k++] = R[j++];
        }
    }
}
