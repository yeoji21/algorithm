package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main17142 {
    private static int[][] lab;
    private static int N, M;
    private static int result = Integer.MAX_VALUE, zeroCount = 0;
    private static List<Point> enableToPutVirus;
    private static int[] selected;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];
        selected = new int[M];
        enableToPutVirus = new ArrayList<>(20);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 0) zeroCount++;
                if(lab[i][j] == 2) enableToPutVirus.add(new Point(i, j));
            }
        }
        if(zeroCount == 0) {
            System.out.println(0);
            return;
        }

        spreadVirus(0, 0);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    private static void spreadVirus(int level, int count) {
        if (count == M) {
            result = Math.min(result, calculateSpreadTime(zeroCount));
        }
        else{
            for (int i = level; i < enableToPutVirus.size(); i++) {
                selected[count] = i;
                spreadVirus(i + 1, count + 1);
            }
        }
    }

    private static int calculateSpreadTime(int zeroCount) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] checked = new boolean[N][N];
        Arrays.stream(selected).forEach(i -> {
            Point point = enableToPutVirus.get(i);
            queue.add(point);
            checked[point.x][point.y] = true;
        });

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (--size >= 0) {
                Point now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                    if(lab[nx][ny] == 1 || checked[nx][ny]) continue;

                    checked[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    if(lab[nx][ny] == 0) zeroCount--;
                }
            }
            time++;
            if (zeroCount == 0) {
                return time;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}