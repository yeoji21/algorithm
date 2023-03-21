package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main2417 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        long n = reader.nextLong();
        long left = 0, right = n;
        long ans = 0;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long pow = (long) Math.pow(mid, 2);
            if (pow < n) {
                left = mid + 1;
            } else{
                ans = mid;
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main2417().input(new FastReader());
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
