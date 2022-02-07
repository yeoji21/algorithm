package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2468 {
    static int N, map[][], checked[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        checked = new int[N][N];
        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                nums.add(num);
                map[i][j] = num;
            }
        }

        Collections.sort(new ArrayList<>(nums));
        int max = 1;
        for (Integer num : nums) {
            max = Math.max(max, getCount(num));
        }
        System.out.println(max);
    }

    private static int getCount(int targetNum) {
        checked = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= targetNum) map[i][j] = 0;
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(checked[i][j] == 0 && map[i][j] != 0){
                    BFS(i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        checked[x][y] = 1;

        while (!queue.isEmpty()) {
            Point poll = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 0 || checked[nx][ny] == 1) continue;

                checked[nx][ny] = 1;
                queue.add(new Point(nx, ny));
            }
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
