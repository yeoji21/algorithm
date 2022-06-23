package programmers_level1;

import java.util.stream.IntStream;

public class x만큼_간격이_있는_n개의_숫자 {
    public long[] solution(int x, int n) {
        return IntStream.range(1, n + 1)
                .mapToLong(i -> (long) i * x)
                .toArray();
    }
}
