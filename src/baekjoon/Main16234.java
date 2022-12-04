package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main16234 {
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private int[][] map;
    private boolean[][] checked;
    private int N, L, R;
    private Queue<int[]> queue;
    private List<int[]> united;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        L = getIntToken(tokenizer);
        R = getIntToken(tokenizer);
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntToken(tokenizer);
            }
        }

        int answer = 0;
        while (true) {
            checked = new boolean[N][N];
            int moved = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(checked[i][j]) continue;
                    moved = BFS(i, j) ? moved + 1 : moved;
                }
            }
            if(moved == 0) break;
            answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean BFS(int x, int y) {
        queue = new LinkedList<>();
        united = new ArrayList<>();
        queue.add(new int[]{x, y});
        checked[x][y] = true;
        united.add(new int[]{x, y});
        int people = map[x][y];
        boolean moved = false;
        int total = people;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                int gap = Math.abs(map[now[0]][now[1]] - map[nx][ny]);
                if(checked[nx][ny] || gap < L || gap > R) continue;
                if(map[nx][ny] != people) moved = true;
                checked[nx][ny] = true;
                int[] next = {nx, ny};
                queue.add(next);
                united.add(next);
                total += map[nx][ny];
            }
        }

        if (moved) {
            for (int i = 0; i < united.size(); i++) {
                map[united.get(i)[0]][united.get(i)[1]] = total / united.size();
            }
        }

        return moved;
    }

    public static void main(String[] args) throws Exception {
        new Main16234().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
