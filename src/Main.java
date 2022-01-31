import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        new Main().solution(num, 0, n - 1);
        Arrays.stream(num).forEach(x -> System.out.print(x + " "));
    }

    public void solution(int[] num, int start, int end) {
        if (start >= end) return;

        int part = partition(num, start, end);
        Arrays.stream(num).forEach(x -> System.out.print(x + " "));
        System.out.println();
        solution(num, start, part - 1);
        solution(num, part+1, end);
    }

    private int partition(int[] num, int start, int end) {
        int pivot = start;
        int left = start + 1;
        int right = end;

        System.out.println("left = "+left);
        System.out.println("right = "+right);

        while (left <= right) {
            while(left <= end && num[left] < num[pivot]) left++;
            while(right > start && num[right] >= num[pivot]) right--;

            System.out.println("left = "+left);
            System.out.println("right = "+right);
            if (left > right) {
                swap(num, right, pivot);
            }
            else{
                swap(num, left, right);
            }
        }
        System.out.println(right);
        return right;
    }

    private void swap(int[] num, int start, int end) {
        int temp = num[start];
        num[start] = num[end];
        num[end] = temp;
    }
}