package programmers_level2;

public class 숫자_블록 {
    public int[] solution(long begin, long end) {
        int start = (int) begin;
        int last = (int) end;
        int[] answer = new int[last - start + 1];

        int idx = 0;
        for (int i = start; i < end + 1; i++) {
            answer[idx++] = getBlockNumber(i);
        }
        return answer;
    }

    private int getBlockNumber(int target) {
        if(target == 1) return 0;
        for (int i = 2; i <= Math.sqrt(target); i++) {
            if(target % i == 0 && target / i <= 10_000_000)
                return target / i;
        }
        return 1;
    }
}
