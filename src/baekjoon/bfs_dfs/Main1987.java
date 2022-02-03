package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1987 {
    static int[][] map;
    static int r, c;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] checked = new int[27];
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = chars[j]-'A';
            }
        }

        new Main1987().dfs(0, 0, 0);
        System.out.println(max);
    }

    private void dfs(int x, int y, int count) {
        if (checked[map[x][y]] == 1){
            max = Math.max(max, count);
            return;
        }
        checked[map[x][y]] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            dfs(nx, ny, count+1);
        }
        checked[map[x][y]] = 0;
    }
}
