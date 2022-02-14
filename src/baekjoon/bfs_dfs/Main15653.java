package baekjoon.bfs_dfs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main15653 {
    static int N, M;
    static char[][] map;
    static Ball red, blue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                char value = chars[j];
                if(value == 'R') red = new Ball(i, j);
                if(value == 'B') blue = new Ball(i, j);
                map[i][j] = value;
            }
        }

        if(BFS()) System.out.println(count);
        else System.out.println(-1);
    }

    private static boolean BFS() {
        Queue<Ball[]> queue = new LinkedList<>();
        queue.add(new Ball[]{red, blue});

        boolean[][][][] checked = new boolean[N][M][N][M];
        checked[red.x][red.y][blue.x][blue.y] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Ball[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Ball r = new Ball(now[0].x, now[0].y);
                    Ball b = new Ball(now[1].x, now[1].y);
                    boolean redFirst = r.isFirst(b, j);

                    r.moveBall(j);
                    b.moveBall(j);

                    if(map[b.x][b.y] == 'O') continue;

                    if(r.x == b.x && r.y == b.y) r.setOrder(b, j, redFirst);

                    if(map[r.x][r.y] == 'O') return true;

                    if(checked[r.x][r.y][b.x][b.y]) continue;
                    checked[r.x][r.y][b.x][b.y] = true;

                    queue.add(new Ball[]{r, b});

                }
            }
        }
        return false;
    }

    static class Ball{
        int x, y;

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void moveBall(int d) {
            while (true) {
                int nx = this.x + dx[d];
                int ny = this.y + dy[d];
                if(map[nx][ny] == '#') break;

                this.x = nx;
                this.y = ny;
                if(map[nx][ny] == 'O') break;
            }
        }

        public boolean isFirst(Ball target, int d) {
            if ((d == 0 && this.x < target.x) ||
                    (d == 1 && this.x > target.x) ||
                    (d == 2 && this.y < target.y) ||
                    (d == 3 && this.y > target.y)) return true;
            return false;
        }

        public void setOrder(Ball target, int d, boolean redFirst) {
            switch (d) {
                case 0 :
                    if(redFirst) target.x++;
                    else this.x ++;
                    break;
                case 1:
                    if(redFirst) target.x--;
                    else this.x --;
                    break;
                case 2:
                    if(redFirst) target.y++;
                    else this.y++;
                    break;
                case 3:
                    if(redFirst) target.y--;
                    else this.y--;
                    break;
            }
        }
    }
}
