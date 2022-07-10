package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    public int solution(int[][] maps) {
        int width = maps.length;
        int height = maps[0].length;

        boolean[][] checked = new boolean[width][height];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        checked[0][0] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                Point now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx < 0 || nx >= width || ny < 0 || ny >= height) continue;
                    if(nx == width-1 && ny == height-1) return count;
                    if(maps[nx][ny] == 0 || checked[nx][ny]) continue;

                    checked[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return -1;
    }

    class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
