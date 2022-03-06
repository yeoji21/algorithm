package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main16918 {
    static int R, C, N;
    static char[][] map;
    static Set<Point> bombs = new HashSet<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = getIntToken(st);
        C = getIntToken(st);
        N = getIntToken(st) - 1;

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = chars[j];
                if(chars[j] == 'O') bombs.add(new Point(i, j));
            }
        }

        if(N % 2 == 1){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print("O");
                }
                System.out.println();
            }
            return;
        }

        solution(N);
    }

    private static void solution(int time) {
        while (--time > 0) {
            Arrays.stream(map).forEach(a -> Arrays.fill(a, 'O'));

            bombs.stream().forEach(p -> {
                map[p.x][p.y] = '.';
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    map[nx][ny] = '.';
                }
            });

            bombs = new HashSet<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] == 'O')
                        bombs.add(new Point(i, j));
                }
            }
            time --;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
