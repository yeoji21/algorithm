package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main16234 {
    static int N, L, R;
    static int[][] map;
    static int[][] check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);
        L = getIntToken(st);
        R = getIntToken(st);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntToken(st);
            }
        }

        System.out.println(move());
    }

    private static int move() {
        int time = 0;
        Map<Integer, Integer> dict = new HashMap<>();

        while (true) {
            check = new int[N][N];
            int index = 1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(check[i][j] == 0) {
                        int bfs = BFS(i, j, index);
                        dict.put(index, bfs);
                        index++;
                    }
                }
            }
            if (index > N * N) break;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = dict.get(check[i][j]);
                }
            }
            time++;
        }
        return time;
    }

    private static int BFS(int x, int y, int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        check[x][y] = index;
        int count = 1;
        int sum = map[x][y];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0 || ny < 0|| nx >= N || ny >= N || check[nx][ny] != 0) continue;
                int diff = Math.abs(map[now[0]][now[1]] - map[nx][ny]);

                if(diff >= L && diff <= R) {
                    check[nx][ny] = index;
                    queue.add(new int[]{nx, ny});
                    count++;
                    sum += map[nx][ny];
                }
            }
        }
        return sum / count;
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
