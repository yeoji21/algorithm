package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main3055 {
    static int R, C;
    static char[][] map;
    static Point start, dest;
    static Queue<Point> waters = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                char aChar = chars[j];
                if(aChar == 'D') dest = new Point(i, j);
                if(aChar == 'S') start = new Point(i, j);
                if(aChar == '*') waters.offer(new Point(i, j));
                map[i][j] = aChar;
            }
        }

        if(!BFS()) System.out.println("KAKTUS");
    }

    private static boolean BFS() {
        boolean[][] checked = new boolean[R][C];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        checked[start.x][start.y] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            spreadWater();
            while(size-- > 0){
                Point now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(rangeCheck(nx, ny)) continue;

                    char value = map[nx][ny];
                    if(checked[nx][ny] || value == 'X' || value == '*') continue;

                    if(value == 'D') {
                        System.out.println(time);
                        return true;
                    }

                    map[nx][ny] = 'S';
                    checked[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return false;
    }

    private static void spreadWater() {
        int size = waters.size();
        while (size-- > 0) {
            Point water = waters.poll();
            for (int i = 0; i < 4; i++) {
                int nx = water.x + dx[i];
                int ny = water.y + dy[i];

                if(rangeCheck(nx, ny)) continue;
                char value = map[nx][ny];
                if(value == 'X' || value == 'D' || value == '*') continue;

                map[nx][ny] = '*';
                waters.offer(new Point(nx, ny));
            }
        }
    }

    private static boolean rangeCheck(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= R || ny >= C;
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
