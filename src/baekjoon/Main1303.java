package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1303 {
    private char[][] map;
    private boolean[][] checked;
    private int blueTeam;
    private int writeTeam;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void solv() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        blueTeam = writeTeam = 0;
        int N = getIntToken(tokenizer);
        int M = getIntToken(tokenizer);
        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        checked = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (checked[i][j]) continue;
                BFS(i, j);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(writeTeam).append(" ").append(blueTeam);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
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
                if(nx > checked.length -1 || nx < 0 || ny > checked[0].length -1 || ny < 0) continue;
                if(checked[nx][ny] || map[x][y] != map[nx][ny]) continue;

                checked[nx][ny] = true;
                count++;
                queue.add(new int[]{nx, ny});
            }
        }
        if(map[x][y] == 'W')
            writeTeam += Math.pow(count, 2);
        else
            blueTeam += Math.pow(count, 2);
    }

    public static void main(String[] args) throws Exception {
        new Main1303().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
