package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main22944 {
    private StringBuilder answer = new StringBuilder();
    /*
    두 곳을 제외하고 비가 내림
    안전지대로 이동해야 함
    우산이 K개 있고, 우산은 내구도 D를 가짐
     */
    private int N, H, D;
    private char[][] map;
    private boolean[] picked;
    private int min = Integer.MAX_VALUE;
    private List<int[]> umbrellas = new ArrayList<>();
    private void input(FastReader reader) throws Exception{
        N = reader.nextInt();
        H = reader.nextInt();
        D = reader.nextInt();
        map = new char[N][N];
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < N; i++) {
            String s = reader.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }else if(map[i][j] == 'E'){
                    end[0] = i;
                    end[1] = j;
                } else if (map[i][j] == 'U') {
                    umbrellas.add(new int[]{i, j});
                }
            }
        }
        picked = new boolean[umbrellas.size()];
        DFS(start[0], start[1], end[0], end[1], H, 0, 0);
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    private void DFS(int x, int y, int ex, int ey, int HP, int umbrella, int count) {
        int distance = Math.abs(x - ex) + Math.abs(y - ey);
        if (distance <= HP + umbrella) {
            min = Math.min(min, distance + count);
            return;
        }
        for (int i = 0; i < umbrellas.size(); i++) {
            if(picked[i]) continue;
            int[] u = umbrellas.get(i);
            int d = Math.abs(x - u[0]) + Math.abs(y - u[1]);
            if(HP + umbrella < d) continue;
            if (umbrella >= d) {
                picked[i] = true;
                DFS(u[0], u[1], ex, ey, HP, D, count + d);
                picked[i] = false;
            }else{
                picked[i] = true;
                DFS(u[0], u[1], ex, ey, HP - (d - umbrella), D, count + d);
                picked[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main22944().input(new FastReader());
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
