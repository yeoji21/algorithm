package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main15654 {
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
        solution(0, new boolean[n], new int[m]);
        System.out.println(answer.toString());
    }

    private void solution(int depth, boolean[] checked, int[] selected) {
        if(depth == m){
            for (int i = 0; i < selected.length; i++) {
                answer.append(selected[i]).append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            selected[depth] = arr[i];
            solution(depth + 1, checked, selected);
            checked[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main15654().input(new FastReader());
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
