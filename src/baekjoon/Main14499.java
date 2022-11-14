package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14499 {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};
    private int[] dice = new int[7];
    private int[][] map;
    private StringBuilder answer;
    private int x, y;
    private int N, M;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        int X = getIntToken(tokenizer);
        int Y = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);
        map = new int[N][M];
        answer = new StringBuilder();
        x = X;
        y = Y;

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getIntToken(tokenizer);
            }
        }
        tokenizer = new StringTokenizer(br.readLine());
        for (int c = 0; c < K; c++) {
            move(getIntToken(tokenizer) - 1);
        }

        System.out.println(answer.toString());
    }

    private void move(int c) {
        int nx = x + dx[c];
        int ny = y + dy[c];

        if(nx >= N || nx < 0 || ny >= M || ny < 0) return;
        x += dx[c];
        y += dy[c];
        rollingDice(c);

        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[6];
        } else{
            dice[6] = map[nx][ny];
            map[nx][ny] = 0;
        }

        answer.append(dice[1] + "\n");
    }

    private void rollingDice(int c) {
        if (c == 0) {
            int temp = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = temp;
        } else if (c == 1) {
            int temp = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        } else if (c == 2) {
            int temp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;
        } else {
            int temp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main14499().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
