package baekjoon.bfs_dfs;

import java.util.*;

public class Main2583 {
    static int n, m, k;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        map = new int[m][n];

        Spot[] spots = new Spot[k];
        for (int i = 0; i < k; i++) {
            spots[i] = new Spot(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        new Main2583().solution(map, spots);
    }

    public void solution(int[][] map, Spot[] spots) {
        for (Spot spot : spots) {
            for (int a = spot.leftY; a < spot.rightY; a++) {
                for (int b = spot.leftX; b < spot.rightX; b++) {
                    map[a][b] = 1;
                }
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(x -> System.out.print(x + " "));
    }

    private void dfs(int i, int j) {
        map[i][j] = 1;
        count ++;

        for (int l = 0; l < 4; l++) {
            int nx = i + dx[l];
            int ny = j + dy[l];

            if(nx < m && nx >= 0 && ny < n && ny >= 0){
                if(map[nx][ny] == 0){
                    dfs(nx, ny);
                }
            }
        }
    }

    static class Spot{
        private int leftX, leftY;
        private int rightX, rightY;

        public Spot(int leftX, int leftY, int rightX, int rightY) {
            this.leftX = leftX;
            this.leftY = leftY;
            this.rightX = rightX;
            this.rightY = rightY;
        }
    }
}
