package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14923 {
    private static int N, M, Ex, Ey;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);
        M = getIntToken(st);
        map = new int[N+1][M+1];

        st = new StringTokenizer(br.readLine());
        int Hx = getIntToken(st);
        int Hy = getIntToken(st);

        st = new StringTokenizer(br.readLine());
        Ex = getIntToken(st);
        Ey = getIntToken(st);

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = getIntToken(st);
            }
        }

        escapeMaze(Hx, Hy);
    }

    private static void escapeMaze(int hx, int hy) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] checked = new boolean[N+1][M+1][2];
        int time = 0;

        queue.add(new Point(hx, hy, 0));
        checked[hx][hy][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point now = queue.poll();
                if(now.x == Ex && now.y == Ey){
                    System.out.println(time);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx > N || nx < 0 || ny > M || ny < 0) continue;

                    if(map[nx][ny] == 1){
                        if (now.usedChance == 0 && !checked[nx][ny][now.usedChance+1]) {
                            queue.add(new Point(nx, ny, now.usedChance + 1));
                            checked[nx][ny][1] = true;
                        }
                    }
                    else{
                        if(!checked[nx][ny][now.usedChance]) {
                            queue.add(new Point(nx, ny, now.usedChance));
                            checked[nx][ny][now.usedChance] = true;
                        }
                    }
                }
            }
            time++;
        }
        System.out.println(-1);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static class Point{
        int x, y, usedChance;

        public Point(int x, int y, int usedChance) {
            this.x = x;
            this.y = y;
            this.usedChance = usedChance;
        }
    }
}