package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main15651 {
    private StringBuilder answer = new StringBuilder();
    private int n, m;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        solution(0, new int[m]);
        System.out.println(answer.toString());
    }

    private void solution(int depth, int[] selected) {
        if(depth == m){
            for(int i = 0; i < selected.length; i++){
                answer.append(selected[i]).append(" ");
            }
            answer.append("\n");
            return;
        }

        for(int i = 1; i < n + 1; i++){
            selected[depth] = i;
            solution(depth + 1, selected);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main15651().input(new FastReader());
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
