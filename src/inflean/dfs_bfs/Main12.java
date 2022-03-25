package inflean.dfs_bfs;

import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12 {
    static int zeroCount = 0, M, N;
    static int[][] map;
    static boolean[][] checked;
    static List<Point> tomato = new ArrayList<>(100);
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = getIntToken(st);
        N = getIntToken(st);

        map = new int[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getIntToken(st);
                if(map[i][j] == 0) zeroCount++;
                else if(map[i][j] == 1) tomato.add(new Point(i, j));
            }
        }

        if(zeroCount == 0){
            System.out.println(0);
            return;
        }

        tomato.forEach(p -> checked[p.x][p.y] = true);
        BFS();
    }

    private static void BFS() {
        Queue<Point> queue = new LinkedList<>(tomato);
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (--size >= 0) {
                Point now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx < 0 || ny < 0|| nx >= N || ny >= M) continue;
                    if(map[nx][ny] == -1 || checked[nx][ny]) continue;
                    checked[nx][ny] = true;
                    zeroCount--;
                    queue.add(new Point(nx, ny));
                }
            }
            days++;
        }
        if (zeroCount == 0)
            System.out.println(days-1);
        else
            System.out.println(-1);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
