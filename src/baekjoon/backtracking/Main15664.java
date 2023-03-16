package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main15664 {
    private StringBuilder answer = new StringBuilder();
    private int n, m;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        Arrays.sort(arr);
        DFS(0, 0, new int[m]);
        System.out.println(answer.toString());
    }

    private void DFS(int depth, int start, int[] selected) {
        if (depth == m) {
            for (int i = 0; i < selected.length; i++) {
                answer.append(selected[i]).append(" ");
            }
            answer.append("\n");
            return;
        }
        int before = 0;
        for (int i = start; i < arr.length; i++) {
            if(arr[i] == before) continue;
            before = arr[i];
            selected[depth] = arr[i];
            DFS(depth + 1, i + 1, selected);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main15664().input(new FastReader());
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
