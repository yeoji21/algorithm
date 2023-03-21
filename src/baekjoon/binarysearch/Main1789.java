package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main1789 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        long n = reader.nextLong();
        long result = 0;
        long start = 1;
        long end = n;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = (mid * (mid + 1)) / 2;
            if(sum > n){
                end = mid - 1;
            }else{
                start = mid + 1;
                result = mid;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main1789().input(new FastReader());
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
