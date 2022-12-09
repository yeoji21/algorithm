package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main12100 {
    private int N;
    private int[][] map;
    private int answer = 0;

    //상 하 좌 우
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private boolean[][] merged;
    private int[][] temp;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntToken(tokenizer);
            }
        }

        DFS(0, new int[5]);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void DFS(int level, int[] selected) {
        if (level == 5) {
            confirm(selected);
            return;
        }

        for (int d = 0; d < 4; d++) {
            selected[level] = d;
            DFS(level + 1, selected);
        }
    }

    private void confirm(int[] selected) {
        temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = map[i][j];
            }
        }

        for (int idx = 0; idx < selected.length; idx++) {
            merged = new boolean[N][N];
            int d = selected[idx];

            if (d == 0) { //상
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        move(i, j, 0);
                    }
                }
            } else if (d == 1) { //하
                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < N; j++) {
                        move(i, j, 1);
                    }
                }
            } else if (d == 2) { //좌
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        move(i, j, 2);
                    }
                }
            } else { // 우
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j >= 0; j--) {
                        move(i, j, 3);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, temp[i][j]);
            }
        }
    }

    private void move(int x, int y, int d) {
        if(temp[x][y] == 0) return;

        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= N || nx < 0 || ny >= N || ny < 0) return;
            if(merged[nx][ny]) return;

            if (temp[nx][ny] == temp[x][y]) {
                merged[nx][ny] = true;
                temp[nx][ny] *= 2;
                temp[x][y] = 0;
                return;
            } else if(temp[nx][ny] != 0) return;

            temp[nx][ny] = temp[x][y];
            temp[x][y] = 0;
            x = nx;
            y = ny;
        }

    }

    public static void main(String[] args) throws Exception {
        new Main12100().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}