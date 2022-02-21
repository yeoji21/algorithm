import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static char[][] map;
    private static int[][] distance;
    static int W, H, answer;
    static boolean[] selected;
    private static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) break;

            map = new char[W][H];
            for (int i = 0; i < W; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < H; j++) {
                    map[i][j] = chars[j];
                    if(chars[j] == 'o') list.add(0, new Point(i, j));
                    if(chars[j] == '*') list.add(new Point(i, j));
                }
            }

            int size = list.size();
            distance = new int[size][size];
            selected = new boolean[size];

            for (int idx = 0; idx < size; idx++) {
                if(BFS(idx) == -1){
                    answer = -1;
                    break;
                }
            }
            if(answer == -1){
                System.out.println(answer);
                continue;
            }else{
                answer = Integer.MAX_VALUE;
                selected[0] = true;
                DFS(0, 0, 0);
                System.out.println(answer);
            }
        }
    }

    private static void DFS(int from, int dist, int depth) {
        if (depth == selected.length - 1) {
            answer = Math.min(answer, dist);
            return;
        }
        for (int to = 1; to < selected.length; to++) {
            if (!selected[to]) {
                selected[to] = true;
                DFS(to, dist + distance[from][to], depth++);
                selected[to] = false;
            }
        }
    }

    private static int BFS(int from) {
        boolean[][] visited = new boolean[W][H];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Point> queue = new LinkedList<>();

        int dust = 0, cnt = 0;
        Point start = list.get(from);
        visited[start.x][start.y] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                    if(visited[nx][ny] || map[nx][ny] == 'x') continue;

                    if (map[nx][ny] == 'o' || map[nx][ny] == '*') {
                        for (int to = 0; to < list.size(); to++) {
                            Point end = list.get(to);
                            if(end.x == nx && end.y == ny){
                                distance[from][to] = distance[to][from] = cnt;
                                dust++;
                            }
                        }
                    }
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        if(dust != list.size() - 1)
            return -1;
        return 0;
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}