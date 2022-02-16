package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17141 {
    static int N, M;
    static int[][] map;
    static List<Point> viruses = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Point[] selectedLocation;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selectedLocation = new Point[M];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if(value == 2) viruses.add(new Point(i, j));
            }
        }

        getVirusLocation(0, 0);

        if(result == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(result);
    }

    private static void getVirusLocation(int count, int level) {
        if (count == M) {
            int[][] copy = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
            BFS(copy);
            return;
        }
        for (int i = level; i < viruses.size(); i++) {
            Point point = viruses.get(i);
            selectedLocation[count] = point;
            map[point.x][point.y] = 3;
            getVirusLocation(count + 1, i+1);
            map[point.x][point.y] = 2;
        }
    }

    private static void BFS(int[][] copy) {
        Queue<Point> queue = new LinkedList<>();
        queue.addAll(List.of(selectedLocation));
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || copy[nx][ny] == 1 || copy[nx][ny] == 3) continue;

                    copy[nx][ny] = 3;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        if(isFull(copy))
            result = Math.min(result, count-1);
    }

    private static boolean isFull(int[][] copy) {
        return Arrays.stream(copy).flatMapToInt(Arrays::stream).allMatch(x -> x == 3 || x == 1);
    }


    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
