package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main19532 {
    private StringBuilder answer = new StringBuilder();
    private int a, b, c, d, e, f;
    private void input(FastReader reader) throws Exception{
        a = reader.nextInt();
        b = reader.nextInt();
        c = reader.nextInt();
        d = reader.nextInt();
        e = reader.nextInt();
        f = reader.nextInt();

        solution();
    }

    private void solution() {
        int low = -999;
        int high = 999;

        for(int i = low; i <= high; i++){
            for(int j = low; j <= high; j++){
                if(a * i + b * j == c && d * i + e * j == f){
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main19532().input(new FastReader());
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
