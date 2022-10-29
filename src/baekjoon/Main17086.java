package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main17086 {
    private int[][] matrix;
    private int max = Integer.MIN_VALUE;
    private int N, M;
    private int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = getIntToken(tokenizer);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] == 1) continue;
                BFS(i, j);
            }
        }


        bw.write((max + 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] checked = new boolean[N][M];
        queue.add(new int[]{x, y});
        checked[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] now = queue.poll();

                for (int d = 0; d < 8; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];

                    if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                    if(checked[nx][ny]) continue;

                    if(matrix[nx][ny] == 1){
                        max = Math.max(max, count);
                        return;
                    }
                    checked[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
            count++;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main17086().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
