package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3197 {
    private Queue<Point> queue;
    private char[][] river;
    private int[][] melted;
    private int R, C;
    private Point[] ducks = new Point[2];
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int maxDay = 0;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        R = getIntToken(tokenizer);
        C = getIntToken(tokenizer);
        river = new char[R][C];
        queue = new LinkedList<>();
        int duckIdx = 0;

        for (int i = 0; i < R; i++) {
            river[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(river[i][j] == 'X') continue;
                queue.add(new Point(i, j));
                if(river[i][j] == 'L')
                    ducks[duckIdx++] = new Point(i, j);
            }
        }
        BFS();

        int left = 0, right = maxDay;
        int answer = maxDay;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isReachable(ducks[0], ducks[1], mid)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void BFS() {
        boolean[][] checked = new boolean[R][C];
        melted = new int[R][C];
        queue.forEach(p -> checked[p.x][p.y] = true);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point water = queue.poll();
                maxDay = Math.max(maxDay, melted[water.x][water.y]);

                for (int d = 0; d < 4; d++) {
                    int nx = water.x + dx[d];
                    int ny = water.y + dy[d];

                    if(nx >= R || nx < 0 || ny >= C || ny < 0) continue;
                    if(checked[nx][ny] || river[nx][ny] != 'X') continue;

                    checked[nx][ny] = true;
                    melted[nx][ny] = melted[water.x][water.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    private boolean isReachable(Point first, Point second, int days) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] checked = new boolean[R][C];
        queue.add(new Point(first.x, first.y));
        checked[first.x][first.y] = true;

        while (!queue.isEmpty()) {
            Point duck = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = duck.x + dx[d];
                int ny = duck.y + dy[d];

                if (nx >= R || nx < 0 || ny >= C || ny < 0) continue;
                if(checked[nx][ny] || melted[nx][ny] > days) continue;
                if(nx == second.x && ny == second.y) return true;
                checked[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }

        return false;
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main3197().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
