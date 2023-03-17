package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main14391 {
    private StringBuilder answer = new StringBuilder();
    /*
    각 조각은 세로나 가로 크기가 1인 직사각형
    가로 조각은 왼 -> 오
    세로 조각은 위 -> 아래
     */
    private int n, m;
    private int[][] map;
    private boolean[][] checked;
    private int max = Integer.MIN_VALUE;
    private int[] dx = {1, 0};
    private int[] dy = {0, 1};
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = reader.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        checked = new boolean[n][m];
        solution(0, 0);
        System.out.println(max);
    }

    private void solution(int row, int col) {
        if(row >= n){
            calculate();
            return;
        }
        if(col >= m){
            solution(row + 1, 0);
            return;
        }
        checked[row][col] = true;
        solution(row, col + 1);
        checked[row][col] = false;
        solution(row, col + 1);
    }

    private void calculate() {
        int total = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if(checked[i][j]){
                    sum = sum * 10 + map[i][j];
                }else{
                    total += sum;
                    sum = 0;
                }
            }
            total += sum;
        }

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(!checked[i][j]){
                    sum = sum * 10 + map[i][j];
                }else{
                    total += sum;
                    sum = 0;
                }
            }
            total += sum;
        }
        max = Math.max(max, total);
    }

    public static void main(String[] args) throws Exception {
        new Main14391().input(new FastReader());
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
