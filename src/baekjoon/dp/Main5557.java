package baekjoon.dp;

import java.io.*;
import java.util.*;

public class Main5557 {
    private int n;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        long[][] dp = new long[n - 1][21];
        dp[0][arr[0]] = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int num = 0; num < 21; num++) {
                if(num - arr[i] >= 0) dp[i][num] += dp[i - 1][num - arr[i]];
                if(num + arr[i] <= 20) dp[i][num] += dp[i - 1][num + arr[i]];
            }
        }
        System.out.println(dp[n - 2][arr[n - 1]]);
    }

    public static void main(String[] args) throws Exception {
        new Main5557().input(new FastReader());
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextIntLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Integer.parseInt(str);
        }
    }
}
