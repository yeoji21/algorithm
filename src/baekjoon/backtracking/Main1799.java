package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main1799 {
    private int n;
    private int[][] map;
    private boolean[][] isBlack, checked;
    private int writeMax = 0, blackMax = 0;
    private int[] dx = {-1, -1};
    private int[] dy = {-1, 1};

    private void input(FastReader reader) throws Exception {
        n = reader.nextIntLine();
        map = new int[n][n];
        checked = new boolean[n][n];
        isBlack = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = reader.nextInt();
                isBlack[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1);
            }
        }
        DFS(0, 0, true, 0);
        DFS(0, 0, false, 0);
        System.out.println(blackMax + writeMax);
    }

    private void DFS(int row, int col, boolean black, int count) {
        if (col >= n) {
            DFS(row + 1, 0, black, count);
            return;
        }
        if (row >= n) {
            if (black) {
                blackMax = Math.max(blackMax, count);
            }else{
                writeMax = Math.max(writeMax, count);
            }
            return;
        }
        if (map[row][col] == 0 || isBlack[row][col] != black || !check(row, col)) {
            DFS(row, col + 1, black, count);
            return;
        }

        checked[row][col] = true;
        DFS(row, col + 1, black, count + 1);
        checked[row][col] = false;
        DFS(row, col + 1, black, count);
    }

    boolean check(int x, int y) {
        for (int i = 0; i < 2; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                if(nx >= n || nx < 0 || ny >= n || ny < 0) break;
                if(checked[nx][ny]) return false;
                nx += dx[i];
                ny += dy[i];
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main1799().input(new FastReader());
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
