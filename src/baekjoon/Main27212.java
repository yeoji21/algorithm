package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main27212 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int M = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);
        int[][] chemi = new int[K + 1][K + 1];
        for (int i = 1; i < K + 1; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j < K + 1; j++) {
                chemi[i][j] = getIntToken(tokenizer);
            }
        }
        int[] a = getUniv(br, N);
        int[] b = getUniv(br, M);

        long[][] dp = new long[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + chemi[a[i]][b[j]],
                        Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        System.out.println(dp[N][M]);
    }

    private int[] getUniv(BufferedReader br, int size) throws IOException {
        int[] univ = new int[size + 1];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i < size + 1; i++) {
            univ[i] = getIntToken(tokenizer);
        }
        return univ;
    }

    public static void main(String[] args) throws Exception {
        new Main27212().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
