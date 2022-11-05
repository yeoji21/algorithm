package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1194 {
    private int N, M;
    private char[][] map;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private Point start;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j] == '0') start = new Point(i, j, 0);
            }
        }

        int answer = BFS();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS() {
        Queue<Point> Q = new LinkedList<>();
        boolean[][][] checked = new boolean[N][M][1 << 6];

        Q.add(new Point(start.x, start.y, 0));
        checked[start.x][start.y][0] = true;
        int count = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                Point now = Q.poll();
                if(map[now.x][now.y] == '1')
                    return count;
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                    if(map[nx][ny] == '#' || checked[nx][ny][now.key]) continue;

                    Point next = new Point(nx, ny, now.key);
                    if(isKey(nx, ny)){
                        next.key |= 1 << map[nx][ny] - 'a';
                    }else if(isDoor(nx, ny)){
                        if((next.key & 1 << map[nx][ny] - 'A') == 0)
                            continue;
                    }
                    checked[next.x][next.y][next.key] = true;
                    Q.add(next);
                }
            }
            count++;
        }
        return -1;
    }

    private boolean isDoor(int nx, int ny) {
        return map[nx][ny] == 'A' || map[nx][ny] == 'B' || map[nx][ny] == 'C' || map[nx][ny] == 'D' || map[nx][ny] == 'E' || map[nx][ny] == 'F';
    }

    private boolean isKey(int nx, int ny) {
        return map[nx][ny] == 'a' || map[nx][ny] == 'b' || map[nx][ny] == 'c' || map[nx][ny] == 'd' || map[nx][ny] == 'e' || map[nx][ny] == 'f';
    }

    public static void main(String[] args) throws Exception {
        new Main1194().solv();
    }

    static class Point{
        int x, y;
        int key;

        public Point(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
