package backend;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{2, 5, 3, 1, 4});
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static int[] solution(int[] p) {
        int[] result = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            if (p[i] != i + 1) {
                swap(p, result, i);
            }
        }
        return result;
    }

    private static void swap(int[] arr, int[] result, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] == index + 1) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                result[i]++;
                result[index]++;
                break;
            }
        }
    }

}
