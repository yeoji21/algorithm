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
        int pivot = arr[start];
        int left = start;
        int right = end;

        while (left < right) {
            while(pivot < arr[right]) right--;
            while (left < right && pivot >= arr[left]) left++;
            swap(arr, left, right);
        }

        arr[start] = arr[left];
        arr[left] = pivot;
        return left;
    }

    private void swap(int[] num, int start, int end) {
        int temp = num[start];
        num[start] = num[end];
        num[end] = temp;
    }
}
