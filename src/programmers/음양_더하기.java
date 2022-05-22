package programmers;

import java.util.stream.IntStream;

public class 음양_더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, signs.length)
                .map(i -> {
                    if (signs[i]) return absolutes[i];
                    else return -absolutes[i];
                })
                .sum();
    }
}
