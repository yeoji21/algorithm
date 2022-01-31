package inflean.sort;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        new QuickSort().solution(arr, 0, n-1);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }

    public void solution(int[] arr, int start, int end) {
        if(start >= end ) return;

        int part = partition(arr, start, end);
        solution(arr, start, part - 1);
        solution(arr, part + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while(left <= end && arr[left] < arr[pivot]) left++;
            while(right > start && arr[right] >= arr[pivot]) right--;

            if(left > right) swap(arr, pivot, right);
            else swap(arr, left, right);
        }
        return right;
    }
    private void swap(int[] num, int start, int end) {
        int temp = num[start];
        num[start] = num[end];
        num[end] = temp;
    }
}
