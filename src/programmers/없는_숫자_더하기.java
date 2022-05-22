package programmers;

import java.util.Arrays;

public class 없는_숫자_더하기 {
    public int solution(int[] numbers) {
        return 35 - Arrays.stream(numbers).sum();
    }
}
