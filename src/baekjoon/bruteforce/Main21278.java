package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main21278 {
    private StringBuilder answer = new StringBuilder();
    /*
    n개 건물 m개 도로
    건물은 1~n번
    도로는 양 건물 사이를 1시간에 양방향으로 이동
    가장 접근성이 좋은 두 건물 선택
    조합이 여러 개면 작은 건물이 더 작게 -> 큰 건물이 더 작게
     */
    private final int INF = 100_000;
    private int n, m;
    private int minDistance = INF;
    private int[] pick = new int[2];
    private int[][] map;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        map = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int from = reader.nextInt();
            int to = reader.nextInt();
            map[from][to] = 1;
            map[to][from] = 1;
        }

        floyd();
        DFS(0, 1, new int[2]);
        System.out.println(pick[0] + " " + pick[1] + " " + minDistance);
    }

    private void DFS(int depth, int start, int[] selected) {
        if (depth == 2) {
            int sum = 0;
            for (int i = 1; i < n + 1; i++) {
                if(selected[0] == i || selected[1] == i) continue;
                sum += 2 * Math.min(map[i][selected[0]], map[i][selected[1]]);
            }
            if (sum < minDistance) {
                minDistance = sum;
                pick[0] = selected[0];
                pick[1] = selected[1];
            }

            return;
        }
        for (int i = start; i < n + 1; i++) {
            selected[depth] = i;
            DFS(depth + 1, i + 1, selected);
        }
    }

    private void floyd() {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main21278().input(new FastReader());
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
