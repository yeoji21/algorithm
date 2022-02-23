package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main4991_1 {
    private static int H, W;
    private static char[][] map;
    private static List<Point> list;
    private static int[][] distance;
    private static boolean[][] checked;
    private static int dust, result;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) break;

            map = new char[H][W];
            list = new ArrayList<>();

            for (int i = 0; i < H; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    char aChar = chars[j];
                    map[i][j] = aChar;
                    if(aChar == 'o') list.add(0, new Point(i, j));
                    else if(aChar == '*') list.add(new Point(i, j));
                }
            }

            int size = list.size();
            distance = new int[size][size];
            dust = 0;

            for (int i = 0; i < size; i++) {
                BFS(list.get(i), i);
            }

            if(dust == list.size()-1){
                result = Integer.MAX_VALUE;
                visited = new boolean[size];
                visited[0] = true;
                DFS(0, 0, 0);
                sb.append(result + "\n");
            }else{
                sb.append(-1 + "\n");
            }
        }
        System.out.print(sb);
    }

    private static void DFS(int start, int count, int dist) {
        if (count == list.size() - 1) {
            result = Math.min(result, dist);
        }
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i, count + 1, dist + distance[start][i]);
                visited[i] = false;
            }
        }
    }

    private static void BFS(Point point, int start) {
        checked = new boolean[H][W];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        checked[point.x][point.y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point now = queue.poll();

                if (map[now.x][now.y] == '*') {
                    if(start == 0) dust++;

                    for (int to = 1; to < list.size(); to++) {
                        Point p = list.get(to);
                        if(p.x == now.x && p.y == now.y){
                            distance[start][to] = distance[to][start] = count;
                        }
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (checked[nx][ny] || map[nx][ny] == 'x') continue;

                    queue.offer(new Point(nx, ny));
                    checked[nx][ny] = true;
                }
            }
            count++;
        }
    }

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
