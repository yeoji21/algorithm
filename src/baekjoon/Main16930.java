package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16930 {
    private char[][] map;
    private int N, M, K;
    private int startX, startY;
    private int endX, endY;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        K = getIntToken(tokenizer);

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        tokenizer = new StringTokenizer(br.readLine());
        startX = getIntToken(tokenizer) - 1;
        startY = getIntToken(tokenizer) - 1;
        endX = getIntToken(tokenizer) - 1;
        endY = getIntToken(tokenizer) - 1;

        int answer = BFS();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] checked = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(checked[i], Integer.MAX_VALUE);
        }
        queue.add(new int[]{startX, startY});
        checked[startX][startY] = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] now = queue.poll();
                if(now[0] == endX && now[1] == endY) return count;

                for (int d = 0; d < 4; d++) {
                    for (int m = 1; m < K + 1; m++) {
                        int nx = now[0] + dx[d] * m;
                        int ny = now[1] + dy[d] * m;

                        if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                        if(map[nx][ny] == '#') break;
                        if(checked[nx][ny] <= checked[now[0]][now[1]]) break;
                        if(checked[nx][ny] == Integer.MAX_VALUE) {
                            checked[nx][ny] = count;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Main16930().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}