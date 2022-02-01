package baekjoon.bfs_dfs;

import java.util.*;

public class Main2667 {
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int count;
//    static int[][] visited;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        new Main2667().solution();
    }

    public void solution() {
        int result = 0;
        List<Integer> countList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1){
                    count = 0;
                    dfs(i, j);
                    if(count == 0) continue;
                    countList.add(count);
                    result++;
                }
            }
        }

        System.out.println(result);
        countList.stream().mapToInt(x -> x).sorted().forEach(System.out::println);
    }
    private void dfs(int i, int j) {
        map[i][j] = 0;
        count++;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || nx>= n || ny < 0 || ny >= n) continue;

            if(map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
