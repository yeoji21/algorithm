package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main4991 {
    private static int N, M;
    private static char[][] map;
    private static List<Point> robotsAndDust;
    private static int[][] distance;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int checkedDustCount, minDistance;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            M = getIntToken(st);
            N = getIntToken(st);
            if(N == 0 && M == 0) break;

            map = new char[N][M];
            robotsAndDust = new ArrayList<>(20);

            for (int i = 0; i < N; i++) {
                char[] tokens = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = tokens[j];
                    if (map[i][j] == 'o') robotsAndDust.add(0, new Point(i, j));
                    if (map[i][j] == '*') robotsAndDust.add(new Point(i, j));
                }
            }

            int robotAndDustSize = robotsAndDust.size();
            checkedDustCount = 0;
            distance = new int[robotAndDustSize][robotAndDustSize];
            for (int i = 0; i < robotAndDustSize; i++) {
                setDistanceBetweenDust(i);
            }

            if (checkedDustCount == robotAndDustSize - 1) {
                minDistance = Integer.MAX_VALUE;
                visited = new boolean[robotAndDustSize];
                visited[0] = true;
                getMinDistance(0, 0, 0);
                result.append(minDistance + "\n");
            }else{
                result.append(-1 + "\n");
            }
        }

        System.out.println(result);
    }

    private static void getMinDistance(int start, int dist, int count) {
        if (count == robotsAndDust.size() - 1) {
            minDistance = Math.min(minDistance, dist);
        }
        else{
            for (int to = 1; to < robotsAndDust.size(); to++) {
                if (!visited[to]) {
                    visited[to] = true;
                    getMinDistance(to, dist + distance[start][to], count + 1);
                    visited[to] = false;
                }
            }
        }
    }

    private static void setDistanceBetweenDust(int sequence) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] checked = new boolean[N][M];

        Point targetDust = robotsAndDust.get(sequence);
        queue.add(targetDust);
        checked[targetDust.x][targetDust.y] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Point now = queue.poll();

                if(map[now.x][now.y] == '*') {
                    if (sequence == 0) checkedDustCount++;

                    for (int i = 1; i < robotsAndDust.size(); i++) {
                        Point point = robotsAndDust.get(i);
                        if (point.x == now.x && point.y == now.y) {
                            distance[sequence][i] = time;
                            distance[i][sequence] = time;
                        }
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx >= N || nx <0 || ny >= M || ny < 0) continue;
                    if(checked[nx][ny] || map[nx][ny] == 'x') continue;

                    queue.add(new Point(nx, ny));
                    checked[nx][ny] = true;
                }
            }
            time++;
        }
    }


    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
