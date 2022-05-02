import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] coins, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        coins = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(st.nextToken());

        int change = Integer.parseInt(br.readLine());
        dp = new int[change + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        minimumCoinChange();
        System.out.println(dp[change]);
    }

    private static void minimumCoinChange() {
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
    }
}