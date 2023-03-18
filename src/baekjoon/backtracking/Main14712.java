package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main14712 {
    private StringBuilder answer = new StringBuilder();
    /*
    NxM에서 2x2 사각형을 이루지 않는 모든 배치의 가짓 수
    전체 경우의 수에서 2x2 사각형을 이루는 배치의 가짓 수를 빼면 됨
    https://thalals.tistory.com/69 참고
     */
    private int n, m;
    private boolean[][] map;
    private int count = 0;
    private int[] dx = {0, 1, 0, 1};
    private int[] dy = {0, 0, 1, 1};
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        map = new boolean[n][m];
        solution(0, 0);
        System.out.println((int) Math.pow(2, n * m) - count);
    }

    private void solution(int row, int col) {
        if(row >= n){
            check();
            return;
        }
        if(col >= m){
            solution(row + 1, 0);
            return;
        }

        map[row][col] = true;
        solution(row, col + 1);
        map[row][col] = false;
        solution(row, col + 1);
    }

    void check(){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 1; j++){
                boolean nemo = true;
                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if(!map[nx][ny]){
                        nemo = false;
                        break;
                    }
                }
                if(nemo) {
                    count++;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main14712().input(new FastReader());
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
