package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main11559 {
    static int R = 12, C = 6;
    static char map[][];
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static ArrayList<Point> list;
    static boolean[][] checked;
    static Queue<Point> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(process());
    }

    private static int process() {
        int cnt = 0;
        while(true) {
            boolean flag = false;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] == '.') continue;
                    if(burst(i, j, map[i][j])) flag = true;
                }
            }
            if(!flag) return cnt;
            drop();
            cnt++;
        }
    }

    private static boolean burst(int r, int c, char color) {
        list = new ArrayList<>();
        checked = new boolean[R][C];
        q = new LinkedList<>();

        list.add(new Point(r, c));
        checked[r][c] = true;
        q.add(new Point(r, c));

        while(!q.isEmpty()) {
            Point now = q.poll();
            for (int d = 0; d < 4; d++) {
                int rr = now.r + dr[d];
                int cc = now.c + dc[d];
                if(rr < 0 || cc < 0 || rr >= R || cc >= C) continue;
                if(checked[rr][cc]) continue;
                if(map[rr][cc] == color) {
                    list.add(new Point(rr, cc));
                    q.add(new Point(rr, cc));
                    checked[rr][cc] = true;
                }
            }
        }

        if(list.size() >= 4) {
            for (Point p : list) map[p.r][p.c] = '.';
            return true;
        } else {
            return false;
        }
    }

    private static void drop() {
        for (int c = 0; c < C; c++) {
            int empty = -1;

            for (int r = R - 1; r >= 0; r--) {
                if(map[r][c] != '.' && empty == -1) continue;
                else if(map[r][c] == '.' && empty == -1) empty = r;
                else if(map[r][c] != '.' && empty != -1) {
                    map[empty][c] = map[r][c];
                    map[r][c] = '.';
                    empty--;
                }
            }
        }
    }

    static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

