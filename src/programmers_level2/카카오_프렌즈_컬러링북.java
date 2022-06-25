package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오_프렌즈_컬러링북 {
    static int M, N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] check = new boolean[m][n];
        M = m;
        N = n;

        int totalCount = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !check[i][j]){
                    check[i][j] = true;
                    int count = BFS(i, j, picture, check);
                    max = Math.max(max, count);
                    totalCount++;
                }
            }
        }

        return new int[]{totalCount, max};
    }

    private int BFS(int x, int y, int[][] picture, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point now = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    if (nx >= M || nx < 0 || ny >= N || ny < 0) continue;
                    if(visited[nx][ny] || picture[nx][ny] != picture[x][y]) continue;

                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    count++;
                }
            }
        }

        return count;
    }

    class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
