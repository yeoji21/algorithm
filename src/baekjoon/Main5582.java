package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main5582 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        String s = br.readLine();
        String k = br.readLine();
        int sLen = s.length();
        int kLen = k.length();

        int[][] dp = new int[sLen + 1][kLen + 1];
        for(int i = 1; i < sLen + 1; i++){
            for (int j = 1; j < kLen + 1; j++) {
                if(s.charAt(i - 1) == k.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main5582().solv();
    }
}
