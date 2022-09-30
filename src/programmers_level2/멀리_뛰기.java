package programmers_level2;

public class 멀리_뛰기 {
    public long solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        return dp[n];
    }
}
