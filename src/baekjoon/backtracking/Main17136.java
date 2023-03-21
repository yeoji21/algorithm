package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main17136 {
    private StringBuilder answer = new StringBuilder();
    /*
    1x1, 2x2, 3x3, 4x4, 5x5
    5개씩 있음
     */
    private boolean[][] map = new boolean[10][10];
    private int[] boxes = new int[5];
    private int min = Integer.MAX_VALUE;
    private void input(FastReader reader) throws Exception{
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = reader.nextInt() == 1;
            }
        }
        Arrays.fill(boxes, 5);
        DFS(0, 0, 0);
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    private void DFS(int row, int col, int count) {
        if(col >= 10){
            DFS(row + 1, 0, count);
            return;
        }
        if(row >= 10){
            min = Math.min(min, count);
            return;
        }
        if(!map[row][col]){
            DFS(row, col + 1, count);
            return;
        }
        for(int i = 0; i < 5; i++){
            if(boxes[i] == 0) continue;
            if(!isPossible(row, col, i)) continue;
            boxes[i]--;
            check(row, col, i, false);
            DFS(row, col + 1, count + 1);
            check(row, col, i, true);
            boxes[i]++;
        }

    }

    void check(int row, int col, int i, boolean b){
        for(int x = row; x <= row + 4 - i; x++){
            for(int y = col; y <= col + 4 - i; y++){
                map[x][y] = b;
            }
        }
    }

    boolean isPossible(int row, int col, int i){
        if(row + 4 - i >= 10 || col + 4 - i >= 10) return false;
        for(int x = row; x <= row + 4 - i; x++){
            for(int y = col; y <= col + 4 - i; y++){
                if(!map[x][y]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main17136().input(new FastReader());
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
