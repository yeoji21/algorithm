package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14503 {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int answer = 0;
    private int[][] map;
    private boolean[][] checked;
    private int N, M;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        map = new int[N][M];
        checked = new boolean[N][M];
        tokenizer = new StringTokenizer(br.readLine());
        int x = getIntToken(tokenizer);
        int y = getIntToken(tokenizer);
        int d = getIntToken(tokenizer);

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getIntToken(tokenizer);
            }
        }
        clean(x, y, d);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void clean(int x, int y, int direction) {
        if(map[x][y] == 0 && !checked[x][y]) {
            checked[x][y] = true;
            answer++;
        }
        int originalDirection = direction;
        boolean clean = false;
        for (int d = 0; d < 4; d++) {
            int left = (direction + 3) % 4;
            int nx = x + dx[left];
            int ny = y + dy[left];
            if(rangeOver(nx, ny)) continue;
            if(map[nx][ny] == 0 && !checked[nx][ny]) {
                clean = true;
                clean(nx, ny, left);
                break;
            }
            direction = left;
        }
        if (!clean) {
            int nx = x + (dx[originalDirection] * -1);
            int ny = y + (dy[originalDirection] * -1);
            if(rangeOver(nx, ny) || map[nx][ny] == 1) return;
            clean(nx, ny, originalDirection);
        }
    }

    private boolean rangeOver(int nx, int ny) {
        return nx >= N || nx < 0 || ny >= M || ny < 0;
    }

    public static void main(String[] args) throws Exception {
        new Main14503().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
