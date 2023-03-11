package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main1541 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        String s = reader.nextLine();
        solution(s);
    }

    private void solution(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, "-");
        int sum = 0;
        StringTokenizer add = new StringTokenizer(tokenizer.nextToken(), "+");
        while(add.hasMoreTokens()){
            sum += Integer.parseInt(add.nextToken());
        }

        while(tokenizer.hasMoreTokens()){
            add = new StringTokenizer(tokenizer.nextToken(), "+");
            int total = 0;
            while(add.hasMoreTokens()){
                total += Integer.parseInt(add.nextToken());
            }
            sum -= total;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main1541().input(new FastReader());
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
