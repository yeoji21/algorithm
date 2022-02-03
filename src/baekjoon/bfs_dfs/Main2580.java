package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2580 {
    static int[][] map = new int[9][9];
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1, 0};
    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int value = Integer.parseInt(s[j]);
                map[i][j] = value;
                if(value == 0) points.add(new Point(i, j));
            }
        }

        new Main2580().solution( 0);
    }

    public void solution(int count) {
        if(count == points.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }

        Point point = points.get(count);
        int x = point.x;
        int y = point.y;

        for (int i = 1; i < 10; i++) {
            if(check(x, y, i)) {
                map[x][y] = i;
                solution(count+1);
                map[x][y] = 0;
            }
        }
    }

    private boolean check(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if(map[x][i] == value) return false;
            if(map[i][y] == value) return false;
        }

        // 방법 1
        int cx = x/3*3 + 1;
        int cy = y/3*3 + 1;
        for (int j = 0; j < 9; j++) {
            int nx = cx + dx[j];
            int ny = cy + dy[j];
            if(map[nx][ny] == value) return false;
        }

        // 방법 2 -> 더 빠름
//        int n_block = x / 3;
//        int m_block = y / 3;
//        for(int i=0; i<3; i++){
//            for(int j=0; j<3; j++){
//                if(map[(n_block*3)+i][(m_block*3)+j] == value)
//                    return false;
//            }
//        }


        return true;
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
