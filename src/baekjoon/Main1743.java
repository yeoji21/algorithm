package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1743 {
    private boolean[][] map;
    private boolean[][] checked;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    private int answer;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        answer = Integer.MIN_VALUE;

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int M = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);

        map = new boolean[N + 1][M + 1];
        checked = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            map[getIntToken(tokenizer)][getIntToken(tokenizer)] = true;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if(map[i][j] && !checked[i][j])
                    BFS(i, j);
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        checked[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = poll[0] + dx[d];
                int ny = poll[1] + dy[d];

                if(nx > map.length - 1 || nx < 0 || ny > map[0].length - 1|| ny < 0) continue;
                if(!map[nx][ny] || checked[nx][ny]) continue;
                count++;
                checked[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        answer = Math.max(answer, count);
    }

    public static void main(String[] args) throws Exception {
        new Main1743().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
