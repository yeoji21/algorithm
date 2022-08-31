package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int N, M;


    public int solution(int[][] maps) {
        N = maps.length - 1;
        M = maps[0].length - 1;
        return BFS(maps);
    }

    private int BFS(int[][] maps) {
        boolean[][] checked = new boolean[N + 1][M + 1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        checked[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point poll = queue.poll();
                if(poll.x == N && poll.y == M)
                    return poll.count;

                for (int i = 0; i < 4; i++) {
                    int nx = poll.x + dx[i];
                    int ny = poll.y + dy[i];

                    if(nx > N || nx < 0 || ny > M || ny < 0) continue;
                    if(maps[nx][ny] == 0 || checked[nx][ny]) continue;

                    checked[nx][ny] = true;
                    queue.add(new Point(nx, ny, poll.count + 1));
                }
            }
        }

        return -1;
    }

    static class Point{
        int x, y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
