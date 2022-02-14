package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2210 {
    static int[][] map = new int[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] checked = new boolean[1_000_000];
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(i, j, 0, String.valueOf(map[i][j]));
            }
        }
        System.out.println(result);
    }

    private static void DFS(int x, int y, int level, String sum) {
        if (level == 5) {
            int index = Integer.parseInt(sum.toString());
            if(checked[index]) return;
            checked[index] = true;
            result++;
        }
        else{
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

                DFS(nx, ny, level+1, sum+map[nx][ny]);
            }
        }
    }
}
