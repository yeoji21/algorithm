package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main15683 {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int[][] map;
    private int[][] copyMap;
    private List<CCTV> cctv;
    private int N, M;
    private int answer = Integer.MAX_VALUE;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        map = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getIntToken(tokenizer);
                if(map[i][j] == 0 || map[i][j] == 6) continue;
                cctv.add(new CCTV(i, j));
            }
        }

        Permutation[] arr = new Permutation[cctv.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Permutation(map[cctv.get(i).x][cctv.get(i).y]);
        }

        permutation(0, cctv.size(), arr);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void permutation(int level, int limit, Permutation[] selected) {
        if (level == limit) {
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
            }
            for (int i = 0; i < selected.length; i++) {
                turnCCTV(cctv.get(i), selected[i].d);
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(copyMap[i][j] == 0) count++;
                }
            }
            answer = Math.min(answer, count);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(selected[level].cctv == 2 && i > 1) continue;
            if(selected[level].cctv == 5 && i != 0) continue;
            selected[level].d = i;
            permutation(level + 1, limit, selected);
        }
    }

    private void turnCCTV(CCTV cctv, int d) {
        int command = map[cctv.x][cctv.y];
        if (command == 1) {
            watch(cctv, d);
        } else if (command == 2) {
            if (d == 0) {
                watch(cctv, 0);
                watch(cctv, 1);
            } else{
                watch(cctv, 2);
                watch(cctv, 3);
            }
        } else if (command == 3) {
            if (d == 1) {
                watch(cctv, 0);
                watch(cctv, 3);
            } else if (d == 2) {
                watch(cctv, 0);
                watch(cctv, 2);
            } else if (d == 3) {
                watch(cctv, 1);
                watch(cctv, 3);
            } else {
                watch(cctv, 1);
                watch(cctv, 2);
            }
        } else if (command == 4) {
            for (int i = 0; i < 4; i++) {
                if(i == d) continue;
                watch(cctv, i);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                watch(cctv, i);
            }
        }
    }

    private void watch(CCTV cctv, int d) {
        Queue<CCTV> q = new LinkedList<>();
        boolean[][] checked = new boolean[N][M];
        q.add(new CCTV(cctv.x, cctv.y));
        checked[cctv.x][cctv.y] = true;

        while (!q.isEmpty()) {
            CCTV now = q.poll();
            int nx = now.x + dx[d];
            int ny = now.y + dy[d];
            if(rangeCheck(nx, ny) || copyMap[nx][ny] == 6) break;
            if(copyMap[nx][ny] == 0 && !checked[nx][ny]) {
                checked[nx][ny] = true;
                copyMap[nx][ny] = -1;
            }
            q.add(new CCTV(nx, ny));
        }
    }

    static class Permutation{
        int cctv, d;

        public Permutation(int cctv) {
            this.cctv = cctv;
        }
    }

    static class CCTV{
        int x, y;

        public CCTV(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean rangeCheck(int nx, int ny) {
        return nx >= N || nx < 0 || ny >= M || ny < 0;
    }

    public static void main(String[] args) throws Exception {
        new Main15683().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}