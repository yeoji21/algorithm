package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main4991 {
    private static char[][] map;
    private static int[][] distance;
    private static int W, H, result, dirty;
    static boolean[][] visited;
    private static boolean[] checked;
    private static List<Point> list;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) break;

            list = new ArrayList<>();
            map = new char[W][H];

            for (int i = 0; i < W; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < H; j++) {
                    map[i][j] = chars[j];
                    if(chars[j] == 'o') list.add(0, new Point(i, j, 0));
                    if(chars[j] == '*') list.add(new Point(i, j, 0));
                }
            }

            int size = list.size();
            distance = new int[size][size];
            dirty = 0;

            for (int i = 0; i < size; i++) {
                BFS(list.get(i), i);
            }

            if(dirty == list.size()-1){
                result = Integer.MAX_VALUE;
                checked = new boolean[size];
                checked[0] = true;
                DFS(0, 0, 0);
                sb.append(result + "\n");
            }else{
                sb.append(-1 + "\n");
            }
        }
        System.out.print(sb);
    }

    private static void DFS(int start, int cnt, int dist) {
        if(cnt == list.size()-1)
            result = Math.min(result, dist);
        for (int i = 0; i < list.size(); i++) {
            if(!checked[i]){
                checked[i] = true;
                DFS(i, cnt + 1, dist + distance[start][i]);
                checked[i] = false;
            }
        }
    }

    private static void BFS(Point point, int start) {
        visited = new boolean[W][H];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()) {
            Point next = queue.poll();

            if (map[next.x][next.y] == '*') {
                if(start == 0) dirty++;
                for (int to = 1; to < list.size(); to++) {
                    if(next.x == list.get(to).x && next.y == list.get(to).y)
                        distance[start][to] = next.move;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if(visited[nx][ny] || map[nx][ny] == 'x') continue;

                queue.offer(new Point(nx, ny, next.move + 1));
                visited[nx][ny] = true;
            }
        }
    }

    static class Point{
        int x, y, move;

        public Point(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}
