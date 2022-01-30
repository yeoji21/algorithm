package inflean.dfs_bfs;

import java.util.*;

public class Main13 {
    static int result = 0, n;
    static int[][] map;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    new Main13().solution(i, j);
                    result ++;
                }
            }
        }
        System.out.println(result);
    }

    public void solution(int x, int y) {
        if(map[x][y] == 1) {
            map[x][y] = 0;
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= n || nx < 0 || ny >= n || ny < 0 || map[nx][ny] == 0) continue;
                solution(nx, ny);
            }
        }
    }
}