package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main18430 {
    private StringBuilder answer = new StringBuilder();
    /*
    NxM 격자 부위마다 강도가 다름
    ㄱ 모양으로 만들고, 중앙은 강도 두 배로
     */
    private int n, m;
    private int[][] map;
    private boolean[][] checked;
    private int[] dx = {1, 0, -1, 0, -1, 0, 1, 0};
    private int[] dy = {0, -1, 0, -1, 0, 1, 0, 1};
    private int max = 0;
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

        DFS(0, 0, 0);
        System.out.println(max);
    }

    private void DFS(int row, int col, int sum) {
        if(row >= n){
            max = Math.max(max, sum);
            return;
        }
        if(col >= m){
            DFS(row + 1, 0, sum);
            return;
        }
        if(checked[row][col]){
            DFS(row, col + 1, sum);
            return;
        }
        for(int d = 0; d < dx.length; d+=2){
            int nx = row + dx[d];
            int ny = col + dy[d];
            if(nx >= n || nx < 0 || ny >= m || ny < 0 || checked[nx][ny]) continue;
            int rx = row + dx[d + 1];
            int ry = col + dy[d + 1];
            if(rx >= n || rx < 0 || ry >= m || ry < 0 || checked[rx][ry]) continue;
            checked[nx][ny] = true;
            checked[row][col] = true;
            checked[rx][ry] = true;
            DFS(row, col + 1, sum + map[nx][ny] + map[rx][ry] + 2 * map[row][col]);
            checked[nx][ny] = false;
            checked[row][col] = false;
            checked[rx][ry] = false;
        }
        DFS(row, col + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        new Main18430().input(new FastReader());
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
