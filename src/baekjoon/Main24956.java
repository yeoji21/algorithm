package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main24956 {
    private static final int MOD = 1_000_000_007;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long[] dp = new long[4];
        for (char ch : s.toCharArray()) {
            if(ch == 'W') dp[0]++;
            else if(ch == 'H') {
                dp[1] += dp[0];
                if(dp[1] > MOD - 1) dp[1] -= MOD;
            }
            else if(ch == 'E'){
                dp[3] += dp[3] + dp[2];
                while(dp[3] > MOD - 1) dp[3] -= MOD;
                dp[2] += dp[1];
                if(dp[2] > MOD - 1) dp[2] -= MOD;
            }
        }
        System.out.println(dp[3]);
    }

    public static void main(String[] args) throws Exception {
        new Main24956().solv();
    }
}
