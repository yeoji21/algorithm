package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3197_v2 {
    private int R, C;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private char[][] river;
    private Queue<Point> swanQ;
    private Queue<Point> waterQ;
    private Point[] swans = new Point[2];
    private boolean[][] checked;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        R = getIntToken(tokenizer);
        C = getIntToken(tokenizer);
        river = new char[R][C];
        checked = new boolean[R][C];
        swanQ = new LinkedList<>();
        waterQ = new LinkedList<>();
        int duckIdx = 0;

        for (int i = 0; i < R; i++) {
            river[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(river[i][j] == 'L') {
                    river[i][j] = '.';
                    swans[duckIdx++] = new Point(i, j);
                }
                if(river[i][j] == '.')
                    waterQ.add(new Point(i, j));
            }
        }
        swanQ.add(new Point(swans[0].x, swans[0].y));
        checked[swans[0].x][swans[0].y] = true;

        int day = 0;
        while (!movingSwan()) {
            melt();
            day++;
        }
        bw.write(day + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void melt() {
        int size = waterQ.size();
        while (size-- > 0) {
            Point water = waterQ.poll();
            for (int d = 0; d < 4; d++) {
                int nx = water.x + dx[d];
                int ny = water.y + dy[d];

                if (nx >= R || nx < 0 || ny >= C || ny < 0 || river[nx][ny] != 'X') continue;
                river[nx][ny] = '.';
                waterQ.add(new Point(nx, ny));
            }
        }
    }

    private boolean movingSwan() {
        Queue<Point> nextQ = new LinkedList<>();
        while (!swanQ.isEmpty()) {
            Point swan = swanQ.poll();

            for (int d = 0; d < 4; d++) {
                int nx = swan.x + dx[d];
                int ny = swan.y + dy[d];

                if (nx >= R || nx < 0 || ny >= C || ny < 0 || checked[nx][ny]) continue;
                if (nx == swans[1].x && ny == swans[1].y) return true;
                checked[nx][ny] = true;
                if (river[nx][ny] == '.') swanQ.add(new Point(nx, ny));
                else if (river[nx][ny] == 'X') nextQ.add(new Point(nx, ny));
            }
        }
        swanQ = nextQ;
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
        new Main3197_v2().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
