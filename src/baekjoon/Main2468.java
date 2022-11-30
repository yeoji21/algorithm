package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468 {
    private int N;
    private int[][] map;
    private boolean[][] checked;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

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

        int answer = 0;
        for (int h = 0; h < 101; h++) {
            checked = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] <= h) checked[i][j] = true;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(checked[i][j]) continue;
                    BFS(i, j, h);
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void BFS(int x, int y, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        checked[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                if(checked[nx][ny]) continue;
                q.add(new int[]{nx, ny});
                checked[nx][ny] = true;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Main2468().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
