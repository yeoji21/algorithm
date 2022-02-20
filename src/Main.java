import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static Point start, dest;
    static boolean[][][] checked;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        checked = new boolean[N + 1][M + 1][5];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), 0);
        st = new StringTokenizer(br.readLine());
        dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), 0);
        BFS();
    }

    private static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        checked[start.x][start.y][start.d] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;
            int dir = now.d;
            int count = now.count;

            if (isAnswer(x, y, dir)) {
                System.out.println(count);
                return;
            }

            for (int i = 1; i <= 3; i++) {
                int nx = x + dx[dir] * i;
                int ny = y + dy[dir] * i;

                if(rangeCheck(nx, ny) || map[nx][ny] == 1) break;
                if(checked[nx][ny][dir]) continue;

                checked[nx][ny][dir] = true;
                queue.offer(new Point(nx, ny, dir, count + 1));
            }

            for (int i = 1; i <= 4; i++) {
                if(i != dir && !checked[x][y][i]) {
                    queue.offer(new Point(x, y, i, count + directionCheck(dir, i)));
                    checked[x][y][i] = true;
                }
            }
        }
    }

    private static boolean isAnswer(int x, int y, int d) {
        return x == dest.x && y == dest.y && d == dest.d;
    }

    private static int directionCheck(int now, int next) {
        int result = 1;
        if(now == 1 && next == 2) result = 2;
        else if(now == 2 && next == 1) result = 2;
        else if(now == 3 && next == 4) result = 2;
        else if(now == 4 && next == 3) result = 2;
        return result;
    }

    private static boolean rangeCheck(int nx, int ny) {
        return nx <= 0 || ny <= 0 || nx > N || ny > M;
    }

    static class Point{
        int x, y, d, count;

        public Point(int x, int y, int d, int count) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.count = count;
        }
    }
}