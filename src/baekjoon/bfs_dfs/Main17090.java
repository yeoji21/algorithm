package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17090 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static char[][] map;
    static int result = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(move(i, j))
                    result++;
            }
        }
        System.out.println(result);
    }

    private static boolean move(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return true;
        if(map[x][y] == 'T') return true;
        if(map[x][y] == 'F') return false;
        if(visited[x][y]) return false;

        visited[x][y] = true;
        boolean result = false;
        if(map[x][y] == 'U')
            result = move(x + dx[0], y + dy[0]);
        else if(map[x][y] == 'R')
            result = move(x + dx[1], y + dy[1]);
        else if(map[x][y] == 'D')
            result = move(x + dx[2], y + dy[2]);
        else if(map[x][y] == 'L')
            result = move(x + dx[3], y + dy[3]);

        map[x][y] = result ? 'T' : 'F';
        return result;
    }
}
