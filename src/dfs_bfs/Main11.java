package dfs_bfs;

import java.util.*;

public class Main11 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] map, distance;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        map = new int[7][7];
        distance = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        new Main11().solution(0, 0);
        int result = distance[6][6];
        System.out.println(result == 0 ? -1 : result);
    }

    public void solution(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        map[x][y] = 1;

        while (!queue.isEmpty()) {
            Point removed = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = removed.x + dx[i];
                int ny = removed.y + dy[i];

                if (nx < 0 || nx >= 7 || ny < 0 || ny >= 7 || map[nx][ny] > 0) continue;

                queue.add(new Point(nx, ny));
                map[nx][ny] = 1;
                distance[nx][ny] = distance[removed.x][removed.y] + 1;
            }
        }
    }
}

// inner class로 두면 체점 사이트에서 컴파일 에러뜸
class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

