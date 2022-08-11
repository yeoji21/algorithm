package programmers_level2;

import java.util.Arrays;

public class 최솟값_만들기 {
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += A[i] * B[B.length - i - 1];
        }

        return result;
    }
}
