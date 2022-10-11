package programmers_level2;

public class N_Queen {
    private int answer = 0;
    public int solution(int n) {
        for (int i = 0; i < n; i++) {
            int[] dp = new int[n];
            dp[0] = i;
            backtracking(dp, 1);
        }

        return answer;
    }

    private void backtracking(int[] dp, int level) {
        if (level == dp.length) {
            answer++;
            return;
        }
        for (int i = 0; i < dp.length; i++) {
            if(i == dp[level - 1]) continue;
            dp[level] = i;
            if (!check(dp, level)) continue;
            backtracking(dp, level + 1);
        }
    }

    private boolean check(int[] dp, int level) {
        for (int i = 0; i < level; i++) {
            if(dp[i] == dp[level]) return false;
            if(Math.abs(level - i) - Math.abs(dp[level] - dp[i]) == 0) return false;
        }
        return true;
    }
}
