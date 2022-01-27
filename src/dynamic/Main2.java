package dynamic;

import java.util.*;

public class Main2 {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        new Main2().solution();
    }

    public void solution() {
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n+1]);
    }
}
