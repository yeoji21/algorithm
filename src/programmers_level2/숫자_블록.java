package programmers_level2;

public class 숫자_블록 {
    private static int MAX = 10_000_000;

    public int[] solution(long begin, long end) {
        int first = (int) begin;
        int last = (int) end;

        int[] result = new int[last - first + 1];

        for (int i = first; i <= last; i++) {
            result[i - first] = findBlockNumber(i);
        }

        return result;
    }

    private int findBlockNumber(int value) {
        if (value == 1) return 0;

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0 && value / i <= MAX)
                return value / i;
        }

        return 1;
    }
}
