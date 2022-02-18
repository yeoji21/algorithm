package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14923 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken()) - 1;
        int Hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int Ex = Integer.parseInt(st.nextToken()) - 1;
        int Ey = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(Hx, Hy, Ex, Ey);
    }

    private static void BFS(int x, int y, int ex, int ey) {
        int time = 0;
        boolean[][][] checked = new boolean[N][M][2];
        Queue<Point> queue = new LinkedList<>();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        queue.add(new Point(x, y, 0));
        checked[x][y][0] = true;

        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();

            while(size-- > 0){
                Point now = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                    if(map[nx][ny] == 1){
                        if(now.chance == 0 && !checked[nx][ny][now.chance+1]){
                            if(nx == ex && ny == ey){
                                System.out.println(time);
                                return;
                            }
                            queue.add(new Point(nx, ny, now.chance+1));
                            checked[nx][ny][now.chance+1] = true;
                        }

                    }
                    else{
                        if(!checked[nx][ny][now.chance]) {
                            if(nx == ex && ny == ey){
                                System.out.println(time);
                                return;
                            }
                            queue.add(new Point(nx, ny, now.chance));
                            checked[nx][ny][now.chance] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Point{
        int x, y, chance;

        public Point(int x, int y, int chance) {
            this.x = x;
            this.y = y;
            this.chance = chance;
        }
    }
}