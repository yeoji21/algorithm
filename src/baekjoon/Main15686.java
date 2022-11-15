package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main15686 {
    private List<Location> chickens;
    private List<Location> houses;
    private boolean[] closed;
    private int[][] map;
    private int N, M;

    private int answer = Integer.MAX_VALUE;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntToken(tokenizer);
                if(map[i][j] == 1)
                    houses.add(new Location(i, j));
                if(map[i][j] == 2)
                    chickens.add(new Location(i, j));
            }
        }
        closed = new boolean[chickens.size()];
        if (chickens.size() <= M) {
            answer = Math.min(answer, calculateDistance());
        }else{
            DFS(chickens.size() - M, 0);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void DFS(int R, int start) {
        if (R == 0) {
            answer = Math.min(answer, calculateDistance());
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            closed[i] = true;
            DFS(R - 1, i + 1);
            closed[i] = false;
        }

    }

    private int calculateDistance() {
        int distance = 0;
        for (int i = 0; i < houses.size(); i++) {
            int near = Integer.MAX_VALUE;
            for (int j = 0; j < chickens.size(); j++) {
                if(closed[j]) continue;
                Location h = houses.get(i);
                Location c = chickens.get(j);
                near = Math.min(near, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
            }
            distance += near;
        }
        return distance;
    }

    static class Location{
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main15686().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
