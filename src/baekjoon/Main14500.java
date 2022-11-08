package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14500 {
    private int[][] map;
    private boolean[][] checked;
    private int N, M;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int answer = 0;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        map = new int[N][M];
        checked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getIntToken(tokenizer);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                checked[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                checked[i][j] = false;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int x, int y, int level, int sum) {
        if (level == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= N || nx < 0 || ny >= M || ny < 0 || checked[nx][ny]) continue;
            if (level == 2) {
                checked[nx][ny] = true;
                dfs(x, y, level + 1, sum + map[nx][ny]);
                checked[nx][ny] = false;
            }
            checked[nx][ny] = true;
            dfs(nx, ny, level + 1, sum + map[nx][ny]);
            checked[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main14500().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
