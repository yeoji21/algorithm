package programmers;

import java.util.stream.LongStream;

public class 두_정수_사이의_합 {

    public static void main(String[] args) {
        long solution = solution(-5, -2);
        System.out.println(solution);
    }

    public static long solution(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return LongStream.range(min, max + 1).sum();
    }
}
