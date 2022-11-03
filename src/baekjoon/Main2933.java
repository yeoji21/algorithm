package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main2933 {
    private char[][] map;
    private boolean[][] checked;
    private int R, C;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        R = getIntToken(tokenizer);
        C = getIntToken(tokenizer);
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int N = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = R - getIntToken(tokenizer);
            throwSpear(i, height);
            dropMinerals();
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer.append(map[i][j]);
            }
            answer.append("\n");
        }
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void throwSpear(int i, int height) {
        if(i % 2 == 0) leftToRight(height);
        else rightToLeft(height);
    }

    private void dropMinerals() {
        Queue<Point> queue = new LinkedList<>();
        checked = new boolean[R][C];
        for (int i = 0; i < C; i++) {
            if(map[R-1][i] == '.' || checked[R-1][i]) continue;
            checked[R - 1][i] = true;
            queue.add(new Point(R - 1, i));

            while (!queue.isEmpty()) {
                Point now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    if(nx >= R || nx < 0 || ny >= C || ny < 0) continue;
                    if(checked[nx][ny] || map[nx][ny] == '.') continue;
                    checked[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        List<Point> mineralToDrop = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'x' && !checked[i][j]) {
                    map[i][j] = '.';
                    mineralToDrop.add(new Point(i, j));
                }
            }
        }

        if(mineralToDrop.isEmpty()) return;

        boolean canDrop = true;
        while(canDrop) {
            for (Point mineral : mineralToDrop) {
                int nx = mineral.x + 1;
                if (nx >= R || map[nx][mineral.y] == 'x')
                    canDrop = false;
            }
            if (canDrop) {
                for (Point mineral : mineralToDrop) {
                    mineral.x += 1;
                }
            }
        }

        for (Point mineral : mineralToDrop) {
            map[mineral.x][mineral.y] = 'x';
        }
    }

    private void leftToRight(int height) {
        for (int i = 0; i < C; i++) {
            if(map[height][i] == 'x'){
                map[height][i] = '.';
                break;
            }
        }
    }

    private void rightToLeft(int height) {
        for (int i = C - 1; i >= 0; i--) {
            if(map[height][i] == 'x'){
                map[height][i] = '.';
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2933().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
