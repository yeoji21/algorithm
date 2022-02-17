package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main17142 {
    static int N, M;
    static int[][] map;
    static List<Point> viruses = new ArrayList<>();
    static Point[] selectedViruses;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result = Integer.MAX_VALUE;
    static int emptySpace = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        selectedViruses = new Point[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if(value == 2) viruses.add(new Point(i, j));
                if(value == 0) emptySpace++;
            }
        }

        if(emptySpace == 0){
            System.out.println("0");
            return;
        }

        spreadVirus(0, 0);

        if(result == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(result);
    }

    private static void spreadVirus(int count, int level) {
        if (count == M) {
            int[][] copy = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
            BFS(copy, emptySpace);
            return;
        }
        for (int i = level; i < viruses.size(); i++) {
            Point point = viruses.get(i);
            selectedViruses[count] = point;
            map[point.x][point.y] = 3;
            spreadVirus(count + 1, i+1);
            map[point.x][point.y] = 2;
        }
    }

    private static void BFS(int[][] copy, int emptySpace) {
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        boolean[][] checked = new boolean[N][N];
        Arrays.stream(selectedViruses).forEach(x -> {
            queue.add(x);
            checked[x.x][x.y] = true;
        });

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(copy[nx][ny] == 1 || checked[nx][ny]) continue;

                    if(map[nx][ny] == 0) emptySpace--;

                    queue.add(new Point(nx, ny));
                    checked[nx][ny] = true;
                }
            }
            count++;
            if(count >= result) return;
            if(emptySpace <= 0) result = count;
        }

    }

    static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
