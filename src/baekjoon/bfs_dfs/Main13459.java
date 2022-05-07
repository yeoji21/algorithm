package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main13459 {
    private static int N, M;
    private static char[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static Beads red, blue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'B') blue = new Beads(i, j);
                if(map[i][j] == 'R') red = new Beads(i, j);
            }
        }
        if(rollBeads()) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean rollBeads() {
        Queue<Beads[]> queue = new LinkedList<>();
        queue.add(new Beads[]{red, blue});
        boolean[][][][] checked = new boolean[N][M][N][M];
        checked[red.x][red.y][blue.x][blue.y] = true;
        int count = 0;

        while (!queue.isEmpty() && count++ < 10) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Beads[] current = queue.poll();

                for (int d = 0; d < 4; d++) {
                    Beads R = new Beads(current[0].x, current[0].y);
                    Beads B = new Beads(current[1].x, current[1].y);

                    boolean redIsLeading = R.isLeading(B, d);

                    R.move(d);
                    B.move(d);

                    if(map[B.x][B.y] == 'O') continue;
                    if(R.x == B.x && R.y == B.y) setOrder(R, B, d, redIsLeading);
                    if(map[R.x][R.y] == 'O') return true;

                    if(checked[R.x][R.y][B.x][B.y]) continue;
                    checked[R.x][R.y][B.x][B.y] = true;

                    queue.add(new Beads[]{R, B});
                }
            }
        }
        return false;
    }

    private static void setOrder(Beads r, Beads b, int direction, boolean redIsLeading) {

        if(direction == 0){
            if(redIsLeading) b.x++;
            else r.x++;
        } else if (direction == 1) {
            if(redIsLeading) b.x--;
            else r.x--;
        } else if (direction == 2) {
            if (redIsLeading) b.y++;
            else r.y++;
        }else{
            if(redIsLeading) b.y--;
            else r.y--;
        }
    }

    private static class Beads {
        int x, y;

        public Beads(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int direction) {
            while(true){
                int nx = this.x + dx[direction];
                int ny = this.y + dy[direction];

                if(nx < 0 || nx > N || ny < 0 || ny >= M) break;
                if(map[nx][ny] == '#') break;
                this.x = nx;
                this.y = ny;
                if(map[nx][ny] == 'O') break;
            }
        }

        public boolean isLeading(Beads beads, int direction) {
            if(direction == 0){
                return this.x < beads.x;
            } else if (direction == 1) {
                return this.x > beads.x;
            } else if (direction == 2) {
                return this.y < beads.y;
            } else {
                return this.y > beads.y;
            }
        }
    }
}