package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main2667 {
    private int[][] map;
    private boolean[][] checked;
    private List<Integer> answer = new ArrayList<>();
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    private int N;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        checked = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0 || checked[i][j]) continue;
                BFS(i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size() + "\n");
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + "\n");
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        checked[x][y] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                if(checked[nx][ny] || map[nx][ny] == 0) continue;

                checked[nx][ny] = true;
                q.add(new int[]{nx, ny});
                count++;
            }
        }

        answer.add(count);
    }

    public static void main(String[] args) throws Exception {
        new Main2667().solv();
    }
}
