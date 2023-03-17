package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main10971 {
    private StringBuilder answer = new StringBuilder();
    /*
    1 ~ N번 도시
    한 도시에서 출발해서 모두 거쳐 원래도 돌아오는 경로
     */
    private int n;
    private int[][] map;
    private int INF = 1_000_001;
    private int min = Integer.MAX_VALUE;
    private boolean[] checked;
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = reader.nextInt();
                if(map[i][j] == 0) map[i][j] = INF;
            }
        }
        checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            checked[i] = true;
            DFS(0, i, 0, i);
            checked[i] = false;
        }

        System.out.println(min);
    }

    private void DFS(int depth, int from, int sum, int start) {
        if(depth == n - 1){
            min = Math.min(min, sum + map[from][start]);
            return;
        }
        for (int to = 0; to < n; to++) {
            if(checked[to]) continue;
            checked[to] = true;
            DFS(depth + 1, to, sum + map[from][to], start);
            checked[to] = false;
        }
    }


    public static void main(String[] args) throws Exception {
        new Main10971().input(new FastReader());
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
