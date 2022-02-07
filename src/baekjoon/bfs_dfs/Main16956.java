package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main16956 {
    static int R, C;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        List<Wolf> wolves = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                char token = chars[j];
                if(token == 'W') wolves.add(new Wolf(i, j));
                map[i][j] = token;
            }
        }

        for (Wolf wolf : wolves) {
            for (int i = 0; i < 4; i++) {
                int nx = wolf.x + dx[i];
                int ny = wolf.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                if(map[nx][ny] == 'S'){
                    System.out.println("0");
                    System.exit(0);
                }
                if(map[nx][ny] == '.')
                    map[nx][ny] = 'D';
            }
        }

        System.out.println("1");
        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            System.out.println(sb);
        }
    }

    static class Wolf{
        int x, y;

        public Wolf(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}