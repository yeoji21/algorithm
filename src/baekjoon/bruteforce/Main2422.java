package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main2422 {
    private StringBuilder answer = new StringBuilder();
    private int n, m, count = 0;
    private boolean[][] checked;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        checked = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            checked[a][b] = true;
            checked[b][a] = true;
        }

        solution(0, new boolean[n + 1], new int[3], 1);
        System.out.println(count);
    }

    private void solution(int depth, boolean[] picked, int[] selected, int start) {
        if(depth == 3){
            count++;
            return;
        }

        for(int i = start; i < n + 1; i++){
            if(picked[i]) continue;
            if(depth > 0){
                boolean flag = true;
                for(int j = 0; j < depth; j++){
                    if(checked[i][selected[j]]){
                        flag = false;
                        break;
                    }
                }
                if(!flag) continue;
            }
            picked[i] = true;
            selected[depth] = i;
            solution(depth + 1, picked, selected, i + 1);
            picked[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2422().input(new FastReader());
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
