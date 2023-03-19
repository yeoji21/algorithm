package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main9663 {
    private StringBuilder answer = new StringBuilder();
    private int n;
    private int[] arr;
    private int count = 0;
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        arr = new int[n];
        DFS(0);
        System.out.println(count);
    }

    private void DFS(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (!possibleQueen(depth)) continue;
            DFS(depth + 1);
        }
    }

    private boolean possibleQueen(int col) {
        for (int i = 0; i < col; i++) {
            if(arr[i] == arr[col]) return false;
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main9663().input(new FastReader());
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
