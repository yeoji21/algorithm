package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1890 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        StringTokenizer st;

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N + 1][N + 1];
        dp[1][1] = 1;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int next = map[i][j];
                if(next == 0) break;

                if(j + next <= N) dp[i][j + next] += dp[i][j];
                if(i + next <= N) dp[i + next][j] += dp[i][j];

            }
        }

        System.out.println(dp[N][N]);
    }

}