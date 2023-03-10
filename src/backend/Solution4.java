package backend;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
    static int minimumCamping = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solution(new String[]{"..FF", "###F", "###."}, 4);
    }

    private static int solution(String[] grid, int k) {
        char[][] map = new char[grid.length][grid[0].length()];
        boolean[][] checked = new boolean[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {
            map[i] = grid[i].toCharArray();
        }

        BFS(map, checked, k);

        System.out.println(minimumCamping);
        return 0;
    }

    private static void BFS(char[][] map, boolean[][] checked, int k) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        checked[0][0] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point now = queue.poll();

                if(now.x == map.length -1  && now.y == map[0].length -1){
                    StringBuilder sb = new StringBuilder();
                    while (now.previous != null) {
                        sb.append(map[now.previous.x][now.previous.y]);
                        now = now.previous;
                    }
                    String root = sb.reverse().toString();

                    int count = 0;
                    for (int i = 0; i < root.length(); i++) {
                        if(root.charAt(i) == '.') {
                            int next = 0;
                            if(i + k >= root.length()) break;
                            for (int j = 1; j < k + 1; j++) {
                                if(i+j < root.length() && root.charAt(i + j) == '.') {
                                    next = j;
                                }
                            }
                            i += next;
                            count++;
                        }
                    }

                    minimumCamping = Math.min(minimumCamping, count);
                }

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                    if(checked[nx][ny] || map[nx][ny] == '#') continue;

                    checked[nx][ny] = true;
                    queue.add(new Point(nx, ny, now));
                }
            }
        }
    }

    static class Point{
        int x, y;
        Point previous;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, Point previous) {
            this.x = x;
            this.y = y;
            this.previous = previous;
        }
    }
}
