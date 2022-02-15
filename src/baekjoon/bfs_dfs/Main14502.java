package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main14502 {
    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxResult = Integer.MIN_VALUE;
    static List<Virus> virusList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if(value == 2) virusList.add(new Virus(i, j));
            }
        }

        DFS(0, 0,0);
        System.out.println(maxResult);
    }

    private static void DFS(int x, int y,int count) {
        if (count == 3) {
            int[][] copy = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
            virus(copy);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    DFS(i, j, count+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void virus(int[][] copy) {
        Queue<Virus> queue = new LinkedList<>();
        queue.addAll(virusList);

        while (!queue.isEmpty()) {
            Virus poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = poll.x + dx[k];
                int ny = poll.y + dy[k];

                if(nx < 0|| ny < 0 || nx >= N || ny >= M || copy[nx][ny] != 0) continue;

                copy[nx][ny] = 2;
                queue.add(new Virus(nx, ny));
            }
        }

        int count = (int) (Arrays.stream(copy).flatMapToInt(Arrays::stream).filter(num -> num == 0).count());
        maxResult = Math.max(maxResult, count);
    }

    static class Virus{
        int x, y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
