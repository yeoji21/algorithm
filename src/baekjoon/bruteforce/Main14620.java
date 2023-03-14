package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main14620 {
    private StringBuilder answer = new StringBuilder();
    /*
    씨앗 기준 상하좌우로 꽃 영역
    꽃끼리 닿거나 화단 밖으로 나가면 죽음
    꽃 세 개 모두 살리면서 가장 싼 가격
     */
    private int[][] map;
    private int n, min = Integer.MAX_VALUE;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = reader.nextInt();
            }
        }

        solution(0, 0);
        System.out.println(min);
    }

    private void solution(int depth, int sum) {
        if(depth == 3){
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] < 0) continue;

                boolean bloom = true;
                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(nx >= n || nx < 0 || ny >= n || ny < 0 || map[nx][ny] < 0) {
                        bloom = false;
                        break;
                    }
                }
                if(!bloom) continue;

                int price = 0;
                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    price += map[nx][ny];
                    map[nx][ny] ^= -1;
                }
                price += map[i][j];
                map[i][j] ^= -1;

                solution(depth + 1, sum + price);

                map[i][j] ^= -1;
                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    map[nx][ny] ^= -1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main14620().input(new FastReader());
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
