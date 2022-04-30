package inflean.dfs_bfs;

import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12 {
    private static int[][] map;
    private static int M, N;
    private static ArrayList<Point> redTomatoes;
    private static int earlyTomatoCount = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        redTomatoes = new ArrayList<>(M * N);
        map = new int[M][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[j][i] = value;
                if(value == 1) redTomatoes.add(new Point(j, i));
                if(value == 0) earlyTomatoCount++;
            }
        }

        if(earlyTomatoCount == 0) {
            System.out.println(0);
            return;
        }

        spread();
    }

    private static void spread() {
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        queue.addAll(redTomatoes);
        int count = 0;

        while (!queue.isEmpty() && earlyTomatoCount > 0) {
            int size = queue.size();
            while (--size >= 0) {
                Point redTomato = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = redTomato.x + dx[i];
                    int ny = redTomato.y + dy[i];

                    if(nx >= M || nx < 0 || ny >= N || ny < 0) continue;
                    if(map[nx][ny] == 1 || map[nx][ny] == -1) continue;

                    map[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                    earlyTomatoCount--;
                }
            }
            count++;
        }
        if (earlyTomatoCount == 0)
            System.out.println(count);
        else System.out.println(-1);
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
