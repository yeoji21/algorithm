package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main17837 {
    private Horse[] horses;
    private LinkedList<Integer>[][] orders;
    private int[][] map;
    private int[] dx = {0, 0, 0, -1, 1};
    private int[] dy = {0, 1, -1, 0, 0};
    private int N, K;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        K = getIntToken(tokenizer);
        horses = new Horse[K];
        map = new int[N][N];
        orders = new LinkedList[N][N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntToken(tokenizer);
                orders[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = getIntToken(tokenizer) - 1;
            int y = getIntToken(tokenizer) - 1;
            int d = getIntToken(tokenizer);
            horses[i] = new Horse(x, y, d);
            orders[x][y].add(i);
        }

        int answer;
        for (answer = 1; answer <= 1000; answer++) {
            boolean end = false;
            for (int i = 0; i < K; i++) {
                Horse horse = horses[i];
                int nx = horse.x + dx[horse.d];
                int ny = horse.y + dy[horse.d];
                int order = getOrder(i, horse);

                if (rangeCheck(nx, ny) || map[nx][ny] == 2) {
                    horse.d += horse.d % 2 == 0 ? -1 : 1;
                    nx = horse.x + dx[horse.d];
                    ny = horse.y + dy[horse.d];
                    if(rangeCheck(nx, ny) || map[nx][ny] == 2) continue;
                }

                int color = map[nx][ny];
                if(move(horse.x, horse.y, nx, ny, color, order)) {
                    end = true;
                }
            }
            if(end) break;
        }

        bw.write((answer >= 1000 ? -1 : answer) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean move(int x, int y, int nx, int ny, int color, int order) {
        while (orders[x][y].size() > order) {
            int removed;
            if(color == 0)
                removed = orders[x][y].remove(order);
            else
                removed = orders[x][y].removeLast();
            horses[removed].x = nx;
            horses[removed].y = ny;
            orders[nx][ny].add(removed);
        }

        return orders[nx][ny].size() >= 4;
    }

    private boolean rangeCheck(int nx, int ny) {
        return nx >= N || nx < 0 || ny >= N || ny < 0;
    }

    private int getOrder(int num, Horse horse) {
        List<Integer> order = orders[horse.x][horse.y];
        for (int i = 0; i < order.size(); i++) {
            if(order.get(i) == num) return i;
        }
        throw new IllegalArgumentException();
    }

    static class Horse{
        int x, y, d;

        public Horse(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main17837().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
