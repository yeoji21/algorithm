package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static int N, M;
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getNextIntToken(st);
        M = getNextIntToken(st);

        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int x = getNextIntToken(st);
        int y = getNextIntToken(st);
        int d = getNextIntToken(st);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getNextIntToken(st);
            }
        }

        clean(x, y, d);
        System.out.println(result);
    }

    private static void clean(int row, int column, int direction) {
        if(map[row][column] == 0) {
            map[row][column] = 2;
            result++;
        }

        int originalDirection = direction;
        boolean check = false;
        for(int i = 0; i < 4; i++) {
            int leftDirection = (direction + 3) % 4;
            int nx = row + dx[leftDirection];
            int ny = column + dy[leftDirection];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[nx][ny] == 0){
                clean(nx, ny, leftDirection);
                check = true;
                break;
            }
            direction = (direction + 3) % 4;
        }

        if (!check) {
            int nd = (originalDirection + 2) % 4;
            int bnx = row + dx[nd];
            int bny = column + dy[nd];

            if(bnx >= 0 || bny >= 0 || bnx < N || bny < M)
                if(map[bnx][bny]  != 1)
                    clean(bnx, bny, originalDirection);
        }
    }

    private static void clean(Point now) {
        if(map[now.x][now.y] == 0) {
            map[now.x][now.y] = 2;
            result++;
        }

        int originalDirection = now.d;
        boolean check = false;
        for(int i = 0; i < 4; i++) {
            int leftDirection = (now.d + 3) % 4;
            int nx = now.x + dx[leftDirection];
            int ny = now.x + dy[leftDirection];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[nx][ny] == 0){
                clean(new Point(nx, ny, leftDirection));
                check = true;
                break;
            }
            now.d = (now.d + 3) % 4;
        }

        if (!check) {
            int nd = (originalDirection + 2) % 4;
            int bnx = now.x + dx[nd];
            int bny = now.y + dy[nd];

            if(bnx >= 0 || bny >= 0 || bnx < N || bny < M)
                if(map[bnx][bny]  != 1)
                    clean(new Point(bnx, bny, originalDirection));
        }
    }

    private static int getLeftDirection(int now) {
        if(now == 0) return 3;
        else if(now == 1) return 0;
        else if(now == 2) return 1;
        else if(now == 3) return 2;
        return -1;
    }

    private static class Point{
        int x, y, d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    private static int getNextIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
