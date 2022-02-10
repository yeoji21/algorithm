package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main13459 {
    static int N, M;
    static char[][] map;
    static boolean[][] checked;
    static Ball red, blue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                char value = chars[j];
                if(value == 'R') red = new Ball(i, j);
                if(value == 'B') blue = new Ball(i, j);
                map[i][j] = value;
            }
        }

        if(BFS()) System.out.println("1");
        else System.out.println("0");
    }

    private static boolean BFS() {
        Queue<Ball[]> queue = new LinkedList<>();
        queue.add(new Ball[]{red, blue});

        boolean[][][][] checked = new boolean[N][M][N][M];
        checked[red.x][red.y][blue.x][blue.y] = true;

        int count = 0;

        while (!queue.isEmpty() && count++ < 10) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {
                Ball[] current = queue.poll();

                for (int i = 0; i < 4; i++) {
                    Ball r = new Ball(current[0].x, current[0].y);
                    Ball b = new Ball(current[1].x, current[1].y);
                    boolean redFirst = isRedFirst(r, b, i);

                    moveBall(r, i);
                    moveBall(b, i);

                    if(map[b.x][b.y] == 'O') continue;

                    if(r.x == b.x && r.y == b.y)
                        setOrder(r, b, i, redFirst);

                    if(map[r.x][r.y] == 'O')
                        return true;

                    if(checked[r.x][r.y][b.x][b.y]) continue;
                    checked[r.x][r.y][b.x][b.y] = true;

                    queue.add(new Ball[]{r, b});
                }

            }

        }

        return false;
    }

    private static void setOrder(Ball r, Ball b, int i, boolean redFirst) {
        switch (i) {
            case 0 :
                if(redFirst) b.x++;
                else r.x ++;
                break;
            case 1:
                if(redFirst) b.x--;
                else r.x --;
                break;
            case 2:
                if(redFirst) b.y++;
                else r.y++;
                break;
            case 3:
                if(redFirst) b.y--;
                else r.y--;
                break;
        }
    }

    private static void moveBall(Ball ball, int i) {
        while (true) {
            int nx = ball.x + dx[i];
            int ny = ball.y + dy[i];

            if (map[nx][ny] == '#') break;

            ball.x = nx;
            ball.y = ny;

            if (map[nx][ny] == 'O') break;
        }
    }

    private static boolean isRedFirst(Ball r, Ball b, int d) {
        if ((d == 0 && r.x < b.x) ||
                (d == 1 && r.x > b.x) ||
                (d == 2 && r.y < b.y) ||
                (d == 3 && r.y > b.y)) return true;
        return false;
    }

    static class Ball {
        int x, y;

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
