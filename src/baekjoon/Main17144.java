package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main17144 {
    private int[][] map;
    private int[][] addMap;
    private int R, C, T;
    private int[] upperAirPurifier;
    private int[] underAirPurifier;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        R = getIntToken(tokenizer);
        C = getIntToken(tokenizer);
        T = getIntToken(tokenizer);
        map = new int[R][C];
        upperAirPurifier = new int[2];
        underAirPurifier = new int[2];
        boolean upper = false;

        for (int i = 0; i < R; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = getIntToken(tokenizer);
                if (map[i][j] == -1) {
                    if (!upper) {
                        upperAirPurifier[0] = i;
                        upperAirPurifier[1] = j;
                        upper = true;
                    }else{
                        underAirPurifier[0] = i;
                        underAirPurifier[1] = j;
                    }
                }
            }
        }

        for (int t = 0; t < T; t++) {
            addMap = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] == 0 || map[i][j] == -1) continue;
                    spread(i, j);
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] += addMap[i][j];
                }
            }

            upperAir();
            underAir();
        }
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += map[i][j];
            }
        }
        answer += 2;
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void underAir() {
        for (int r = underAirPurifier[0] + 1; r < R - 1; r++) {
            map[r][0] = map[r + 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            map[R - 1][c] = map[R - 1][c + 1];
        }
        for (int r = R - 1; r > underAirPurifier[0]; r--) {
            map[r][C - 1] = map[r - 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            map[underAirPurifier[0]][c] = map[underAirPurifier[0]][c - 1];
        }
        map[underAirPurifier[0]][1] = 0;
    }

    private void upperAir() {
        for (int r = upperAirPurifier[0] - 1; r > 0; r--) {
            map[r][0] = map[r - 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            map[0][c] = map[0][c + 1];
        }
        for (int r = 0; r < upperAirPurifier[0]; r++) {
            map[r][C - 1] = map[r + 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            map[upperAirPurifier[0]][c] = map[upperAirPurifier[0]][c - 1];
        }
        map[upperAirPurifier[0]][1] = 0;
    }

    private void spread(int x, int y) {
        int totalDust = map[x][y];
        if(totalDust < 5) return;
        int dust = totalDust / 5;

        int count = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= R || nx < 0 || ny >= C || ny < 0 || map[nx][ny] == -1) continue;
            count++;
            addMap[nx][ny] += dust;
        }
        map[x][y] = totalDust - (dust * count);
    }

    public static void main(String[] args) throws Exception {
        new Main17144().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
