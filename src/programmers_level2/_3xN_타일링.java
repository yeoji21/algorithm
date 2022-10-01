package programmers_level2;

public class _3xN_타일링 {
    public int solution(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[1] = 2;
        dp[2] = 3;
        for(int i = 3; i < n + 1; i++){
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] % mod + dp[i - 2] % mod;
            } else {
                dp[i] = dp[i - 1] * 2 % mod + dp[i - 2] % mod;
            }
            dp[i] = dp[i] % mod;
        }
        return dp[n];
    }
}
