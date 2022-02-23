package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15684_1 {
    private static int[][] map;
    private static int N, M, H;
    private static int RIGHT = 1, LEFT = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = RIGHT;
            map[x][y + 1] = LEFT;
        }

        for (int i = 0; i <= 3; i++) {
            if (DFS(1, 1, 0, i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static boolean DFS(int x, int y, int count, int limit) {
        if (count == limit) {
            return check();
        }

        for (int i = x; i <= H; i++) {
            for (int j = y; j < N; j++) {
                if(map[i][j] != 0 || map[i][j+1] != 0) continue;

                map[i][j] = RIGHT;
                map[i][j + 1] = LEFT;

                if(DFS(i, j + 2, count + 1, limit)) return true;
                map[i][j] = 0;
                map[i][j + 1] = 0;
            }
            y = 0;
        }
        return false;
    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            int x = 1, y = i;
            for (int j = 1; j <= H; j++) {
                if(map[x][y] == RIGHT) y++;
                else if(map[x][y] == LEFT) y--;
                x++;
            }
            if(y != i) return false;
        }
        return true;
    }
}
