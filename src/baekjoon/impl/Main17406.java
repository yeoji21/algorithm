package baekjoon.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17406 {
    private int[][] map;
    private int[][] rotate;
    private int min = Integer.MAX_VALUE;
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        int m = reader.nextInt();
        int k = reader.nextInt();

        map = new int[n][m];
        rotate = new int[k][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = reader.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) {
                rotate[i][j] = reader.nextInt();
            }
        }

        solution();
        System.out.println(min);
    }

    private void solution() {
        DFS(new boolean[rotate.length], new int[rotate.length], 0);
    }

    void DFS(boolean[] checked, int[] selected, int level){
        if(level == selected.length){
            int[][] temp = new int[map.length][map[0].length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = map[i][j];
                }
            }

            calc(selected, temp);
            return;
        }

        for(int i = 0; i < rotate.length; i++){
            if(checked[i]) continue;
            checked[i] = true;
            selected[level] = i;
            DFS(checked, selected, level + 1);
            checked[i] = false;
        }
    }

    void calc(int[] selected, int[][] map){
        for(int idx : selected){
            int r = rotate[idx][0];
            int c = rotate[idx][1];
            int s = rotate[idx][2];

            rotation(map, c - s - 1, c + s - 1, r -s - 1, r + s - 1);
        }

        for(int i = 0; i < map.length; i++){
            int sum = 0;
            for(int j = 0; j < map[0].length; j++){
                sum += map[i][j];
            }
            min = Math.min(min, sum);
        }
    }

    void rotation(int[][] map, int left, int right, int top, int bottom){
        if(left > right || top > bottom) return;
        int temp = map[top][left];
        for (int i = top; i < bottom; i++) {
            map[i][left] = map[i + 1][left];
        }

        for (int j = left; j < right; j++) {
            map[bottom][j] = map[bottom][j + 1];
        }

        for (int i = bottom; i > top; i--) {
            map[i][right] = map[i - 1][right];
        }

        for (int j = right; j > left; j--) {
            map[top][j] = map[top][j - 1];
        }
        if(left + 1 <= right) map[top][left + 1] = temp;

        rotation(map, left + 1, right - 1, top + 1, bottom - 1);
    }

    public static void main(String[] args) throws Exception {
        new Main17406().input(new FastReader());
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