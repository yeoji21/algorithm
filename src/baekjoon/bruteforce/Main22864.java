package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main22864 {
    private StringBuilder answer = new StringBuilder();
    private int a, b, c, m;
    private void input(FastReader reader) throws Exception{
        a = reader.nextInt();
        b = reader.nextInt();
        c = reader.nextInt();
        m = reader.nextInt();

        solution();
    }

    private void solution() {
        int tired = 0;
        int work = 0;
        for (int i = 0; i < 24; i++) {
            if(tired + a <= m){
                work += b;
                tired += a;
            }else{
                tired -= c;
                tired = Math.max(0, tired);
            }
        }
        System.out.println(work);
    }

    public static void main(String[] args) throws Exception {
        new Main22864().input(new FastReader());
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
