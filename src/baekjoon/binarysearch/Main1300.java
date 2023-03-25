package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main1300 {
    /*
    NxN(10만)을 일차원 배열로 바꿔서 오름차순 정렬했을 때 k번째 수
     */
    private int n;
    private long k;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        k = reader.nextLong();
        solution();
    }

    private void solution() {
        long left = 0, right = (long) n * n + 1;
        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 1; i < n + 1; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(right);
    }

    public static void main(String[] args) throws Exception {
        new Main1300().input(new FastReader());
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
