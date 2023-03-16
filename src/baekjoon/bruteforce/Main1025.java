package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main1025 {
    private StringBuilder answer = new StringBuilder();
    /*
    NxM
    서로 다른 1개 이상의 칸 선택
    행 번호가 등차 수열, 열 번호도 등차수열
    칸에 적힌 수를 이어 붙였을 때 가장 큰 완전 제곱 수 구하기
    없으면 -1
     */
    private int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    private int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
    private int n, m;
    private int[][] map;
    private int max = -1;
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                solution(i, j);
            }
        }
        System.out.println(max);
    }

    private void solution(int i, int j) {
        int sum = map[i][j];
        if(check(sum)) max = Math.max(max, sum);

        for (int w = 1; w < Math.max(n, m); w++) {
            for (int h = 1; h < Math.max(n, m); h++) {
                for(int d = 0; d < 8; d++){
                    sum = map[i][j];
                    int x = i;
                    int y = j;
                    while(true){
                        int nx = x + dx[d] * w;
                        int ny = y + dy[d] * h;
                        if(nx >= n || nx < 0 || ny >= m || ny < 0) break;
                        sum = sum * 10 + map[nx][ny];
                        if(check(sum)) max = Math.max(max, sum);
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
    }

    boolean check(int value){
        int num = (int) Math.sqrt(value);
        return num * num == value;
    }

    public static void main(String[] args) throws Exception {
        new Main1025().input(new FastReader());
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
