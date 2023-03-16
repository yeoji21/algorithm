package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main14500 {
    private StringBuilder answer = new StringBuilder();

    private int n, m;
    private int[][] map;
    private int max = 0;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private boolean[][] checked;

    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        map = new int[n][m];
        checked = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = reader.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checked[i][j] = true;
                DFS(1, i, j, map[i][j]);
                checked[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private void DFS(int depth, int i, int j, int sum) {
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = i + dx[d];
            int ny = j + dy[d];
            if(nx >= n || nx < 0 || ny >= m || ny < 0 || checked[nx][ny]) continue;
            if(depth == 2){
                checked[nx][ny] = true;
                DFS(depth + 1, i, j, sum + map[nx][ny]);
                checked[nx][ny] = false;
            }
            checked[nx][ny] = true;
            DFS(depth + 1, nx, ny, sum + map[nx][ny]);
            checked[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main14500().input(new FastReader());
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
