package programmers_level2;

public class 숫자_블록 {
    private final int MAX = 10_000_000;
    public int[] solution(long begin, long end) {
        int first = (int) begin;
        int last = (int) end;
        int[] answer = new int[last - first + 1];

        int idx = 0;
        for (int i = first; i < last + 1; i++) {
            answer[idx++] = getBlockValue(i);
        }
        return answer;
    }

    private int getBlockValue(int value) {
        if(value == 1) return 0;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if(value % i == 0 && value / i <= MAX)
                return value / i;
        }
        return 1;
    }
}
