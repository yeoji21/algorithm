package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17144 {
    static int R, C, T;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] robot = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = getIntToken(st);
        C = getIntToken(st);
        T = getIntToken(st);

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = getIntToken(st);
                if(map[i][j] == -1) {
                    int idx = robot[0] == 0 ? 0 : 1;
                    robot[idx] = i;
                }
            }
        }

        while (T-- > 0) {
            spread();
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result+2);
    }

    private static void spread() {
        int[][] sum = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] < 5) {
                    sum[i][j] += map[i][j];
                    continue;
                }

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1) continue;
                    cnt++;
                    sum[nx][ny] += map[i][j] / 5;
                }
                sum[i][j] += map[i][j] - (map[i][j] / 5 * cnt);
            }
        }
        upperMove(sum);
        lowerMove(sum);
    }

    private static void upperMove(int[][] sum) {
        int row = robot[0];

        map[row][1] = 0;
        for (int nc = 2; nc < C; nc++) {
            map[row][nc] = sum[row][nc - 1];
        }
        map[row - 1][C - 1] = sum[row][C - 1];
        for (int nr = row - 2; nr >= 0; nr--) {
            map[nr][C - 1] = sum[nr + 1][C - 1];
        }
        map[0][C - 2] = sum[0][C - 1];
        for (int nc = C-3; nc >= 0; nc--) {
            map[0][nc] = sum[0][nc + 1];
        }
        map[1][0] = sum[0][0];
        for (int nr = 2; nr < row; nr++) {
            map[nr][0] = sum[nr - 1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < C-1; j++) {
                map[i][j] = sum[i][j];
            }
        }
    }

    private static void lowerMove(int[][] sum) {
        int row = robot[1];

        map[row][1] = 0;
        for (int nc = 2; nc < C; nc++) {
            map[row][nc] = sum[row][nc - 1];
        }
        map[row + 1][C - 1] = sum[row][C - 1];
        for (int nr = row + 2; nr < R; nr++) {
            map[nr][C - 1] = sum[nr - 1][C - 1];
        }

        map[R-1][C - 2] = sum[R-1][C - 1];
        for (int nc = 0; nc < C-1; nc++) {
            map[R - 1][nc] = sum[R - 1][nc + 1];
        }

        map[R-2][0] = sum[R-1][0];
        for (int nr = R-3; nr > row; nr--) {
            map[nr][0] = sum[nr + 1][0];
        }

        for (int i = row+1; i < R-1; i++) {
            for (int j = 1; j < C-1; j++) {
                map[i][j] = sum[i][j];
            }
        }
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}