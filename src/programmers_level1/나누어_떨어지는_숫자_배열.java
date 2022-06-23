package programmers_level1;

import java.util.Arrays;

public class 나누어_떨어지는_숫자_배열 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] arr, int divisor) {
        int[] result = Arrays.stream(arr)
                .filter(num -> num % divisor == 0)
                .sorted()
                .toArray();

        return result.length == 0 ? new int[]{-1} : result;
    }
}
