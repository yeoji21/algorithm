package programmers_level3;

public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        int min = 0;
        int max = Integer.MAX_VALUE;
        int answer = 0;

        while (min <= max) {
            int mid = (min + max) >>> 1;
            if (check(mid, stones, k)) {
                min = mid + 1;
                answer = mid;
            } else{
                max = mid - 1;
            }
        }

        return answer;
    }

    private boolean check(int value, int[] stones, int k) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < value) {
                count++;
                if(count >= k) return false;
            } else count = 0;
        }
        return true;
    }
}
