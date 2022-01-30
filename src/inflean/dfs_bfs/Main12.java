package inflean.dfs_bfs;

import java.util.*;

public class Main12 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m, n;
    static int[][] tomatoes, day;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        tomatoes = new int[n][m];
        day = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int data = sc.nextInt();
                if (data == 1) queue.add(new Point(i, j));
                tomatoes[i][j] = data;
            }
        }

        if (queue.isEmpty()) System.out.println(-1);
        else {
            new Main12().solution();
            OptionalInt optionalInt = Arrays.stream(tomatoes).flatMapToInt(Arrays::stream).filter(x -> x == 0).findAny();
            if (optionalInt.isPresent()) System.out.println(-1);
            else System.out.println(Arrays.stream(day).flatMapToInt(Arrays::stream).max().getAsInt());
        }
    }

    public void solution() {

        while (!queue.isEmpty()) {
            Point removed = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = removed.x + dx[i];
                int ny = removed.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || tomatoes[nx][ny] != 0) continue;

                tomatoes[nx][ny] = 1;
                day[nx][ny] = day[removed.x][removed.y] + 1;
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
