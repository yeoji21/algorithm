package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오_프렌즈_컬러링북 {
    private int totalArea = 0;
    private int maxAreaSize = 0;
    private boolean[][] checked;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int M, N;

    public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        checked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || checked[i][j]) continue;
                DFS(i, j, picture);
            }
        }

        return new int[]{totalArea, maxAreaSize};
    }

    private void DFS(int x, int y, int[][] picture) {
        totalArea++;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        checked[x][y] = true;
        int target = picture[x][y];
        int area = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point point = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = point.x + dx[d];
                    int ny = point.y + dy[d];
                    if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                    if(picture[nx][ny] != target || checked[nx][ny]) continue;

                    checked[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    area++;
                }
            }
        }
        maxAreaSize = Math.max(maxAreaSize, area);
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
