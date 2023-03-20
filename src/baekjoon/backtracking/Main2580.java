package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main2580 {
    private StringBuilder answer = new StringBuilder();
    private int[][] map;
    private List<int[]> zero = new ArrayList<>();
    private boolean[] checked;
    private int[] dx = {1, 0, -1, 0, 1, -1, 1, -1, 0};
    private int[] dy = {0, 1, 0, -1, 1, 1, -1, -1, 0};

    private boolean find = false;
    private void input(FastReader reader) throws Exception {
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = reader.nextInt();
                if (map[i][j] == 0) zero.add(new int[]{i, j});
            }
        }
        DFS(0);
    }

    private void DFS(int idx) {
        if(find) return;
        if(idx == zero.size()){
            find = true;
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    answer.append(map[i][j]).append(" ");
                }
                answer.append("\n");
            }
            System.out.println(answer.toString());
            return;
        }

        int x = zero.get(idx)[0];
        int y = zero.get(idx)[1];

        for(int i = 1; i < 10; i++){
            if(!check(x, y, i)) continue;
            map[x][y] = i;
            DFS(idx + 1);
            map[x][y] = 0;
        }
    }

    private boolean check(int x, int y, int target) {
        for (int i = 0; i < 9; i++) {
            if(map[x][i] == target) return false;
            if(map[i][y] == target) return false;
        }

        int cx = (x / 3) * 3 + 1;
        int cy = (y / 3) * 3 + 1;
        for (int d = 0; d < 9; d++) {
            int nx = cx + dx[d];
            int ny = cy + dy[d];
            if(map[nx][ny] == target) return false;
        }

        return true;
    }



    public static void main(String[] args) throws Exception {
        new Main2580().input(new FastReader());
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
