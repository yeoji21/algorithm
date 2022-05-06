package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2580 {
    private static int[][] map;
    private static List<Point> zeros;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        zeros = new ArrayList<>();
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) zeros.add(new Point(i, j));
            }
        }

        fillSudokuMap(0);
        printSudokuMap();
    }

    private static void printSudokuMap() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        System.exit(0);
    }

    private static void fillSudokuMap(int count) {
        if(count == zeros.size()){
            printSudokuMap();
        }

        Point zero = zeros.get(count);

        for (int n = 1; n < 10; n++) {
            if(zero.validation(n)){
                map[zero.x][zero.y] = n;
                fillSudokuMap(count + 1);
                map[zero.x][zero.y] = 0;
            }
        }
    }

    private static class Point{
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean validation(int num){
            for (int i = 0; i < 9; i++) {
                if(map[x][i] == num) return false;
                if(map[i][y] == num) return false;
            }

            int n_block = x / 3;
            int m_block = y / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[(n_block * 3) + i][(m_block * 3) + j] == num) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}