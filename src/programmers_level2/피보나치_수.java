package programmers_level2;

public class 피보나치_수 {
    private int[] dp;
    public int solution(int n) {
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        return recursion(n);
    }

    private int recursion(int n) {
        if(dp[n] != 0) return dp[n];
        return dp[n] = (recursion(n - 2) + recursion(n - 1)) % 1234567;
    }
}
