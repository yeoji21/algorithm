package programmers_level2;

public class 피보나치_수 {
    private static int[] dp;
    public int solution(int n) {
        dp = new int[n + 1];
        return fibo(n);
    }

    private int fibo(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] != 0) return dp[n];

        return dp[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
    }
}
