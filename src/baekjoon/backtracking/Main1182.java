package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main1182 {
    private StringBuilder answer = new StringBuilder();
    private int n, s;
    private int[] arr;
    private int count = 0;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        s = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        DFS(0, 0);
        if(s == 0) System.out.println(count - 1);
        else System.out.println(count);
    }

    private void DFS(int depth, int sum) {
        if(depth == n){
            if(sum == s) count++;
            return;
        }
        DFS(depth + 1, sum + arr[depth]);
        DFS(depth + 1, sum);
    }


    public static void main(String[] args) throws Exception {
        new Main1182().input(new FastReader());
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
