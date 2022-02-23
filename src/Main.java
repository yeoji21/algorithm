import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static int N, M;
    private static Point robot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getNextIntToken(st);
        M = getNextIntToken(st);

        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        robot = new Point(getNextIntToken(st), getNextIntToken(st), getNextIntToken(st));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getNextIntToken(st);
            }
        }

        clean();
    }

    private static void clean() {

        map[robot.x][robot.y] = 1;
        int leftDirection = getLeftDirection(robot.d);

    }

    private static int getLeftDirection(int now) {
        if(now == 0) return 3;
        else if(now == 1) return 0;
        else if(now == 2) return 1;
        else if(now == 3) return 2;
        return -1;
    }

    private static class Point{
        int x, y, d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    private static int getNextIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}