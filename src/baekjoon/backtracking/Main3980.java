package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main3980 {
    private StringBuilder answer = new StringBuilder();
    private int[][] stats = new int[11][11];
    private boolean[] checked;
    private int max = 0;
    private void input(FastReader reader) throws Exception{
        int t = reader.nextIntLine();
        while (t-- > 0) {
            max = 0;
            checked = new boolean[11];
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    stats[i][j] = reader.nextInt();
                }
            }
            DFS(0, 0);
            answer.append(max).append("\n");
        }
        System.out.println(answer.toString());
    }

    private void DFS(int position, int sum) {
        if(position == 11){
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 11; i++){
            if(stats[i][position] == 0 || checked[i]) continue;
            checked[i] = true;
            DFS(position + 1, sum + stats[i][position]);
            checked[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main3980().input(new FastReader());
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
