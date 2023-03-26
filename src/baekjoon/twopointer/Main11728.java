package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main11728 {
    private StringBuilder answer = new StringBuilder();
    private int n, m;
    private int[] a, b;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        a = new int[n];
        b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = reader.nextInt();
        }
        solution();
        System.out.println(answer.toString());
    }

    private void solution() {
        int x = 0, y = 0;
        while(x < n && y < m){
            if(a[x] > b[y]){
                answer.append(b[y++]).append(" ");
            }else{
                answer.append(a[x++]).append(" ");
            }
        }

        while(x < n){
            answer.append(a[x++]).append(" ");
        }
        while(y < m){
            answer.append(b[y++]).append(" ");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main11728().input(new FastReader());
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
