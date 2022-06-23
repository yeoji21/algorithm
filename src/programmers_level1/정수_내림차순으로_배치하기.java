package programmers_level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 정수_내림차순으로_배치하기 {
    public long solution(long n) {
        int length = String.valueOf(n).length();
        int[] result = new int[length];

        int idx = 0;
        while (n >= 10) {
            result[idx++] = (int) (n % 10);
            n = n / 10;
        }
        result[idx] = (int) n;

        return Long.parseLong(Arrays.stream(result)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }
}
