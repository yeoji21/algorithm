package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main6593 {
    static char[][][] building;
    static int[][][] checked;
    static int[] dl = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {-0, 0, 0, 0, 1, -1};
    static boolean flag = false;
    static StringBuilder stringBuilder = new StringBuilder();

    static int L, R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point start = null;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new char[L][R][C];
            checked = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    if (s.equals(""))
                        s = br.readLine();
                    char[] chars = s.toCharArray();
                    for (int k = 0; k < C; k++) {
                        char value = chars[k];
                        if (value == 'S') start = new Point(i, j, k);
                        building[i][j][k] = value;
                    }
                }
                br.readLine();
            }

            solution(building, start);
            if (!flag) {
                stringBuilder.append("Trapped!\n");
            }
        }
        System.out.println(stringBuilder);
    }

    public static void solution(char[][][] building, Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start.x, start.y, start.z, 0));
        checked[start.x][start.y][start.z] = 1;
        flag = false;

        while (!queue.isEmpty()) {
            Point poll = queue.remove();

            for (int i = 0; i < dl.length; i++) {
                int nl = poll.x + dl[i];
                int nr = poll.y + dr[i];
                int nc = poll.z + dc[i];

                if (nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C || checked[nl][nr][nc] == 1) continue;
                char target = building[nl][nr][nc];
                if (target == '#') continue;
                if (target == 'E') {
                    flag = true;
                    stringBuilder.append("Escaped in " + (poll.count + 1) + " minute(s).\n");
                    return;
                }
                queue.add(new Point(nl, nr, nc, poll.count + 1));
                checked[nl][nr][nc] = 1;
            }
        }

        return;
    }

    static class Point {
        int x, y, z;
        int count;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Point(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}