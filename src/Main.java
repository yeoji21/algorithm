import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] checked;

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(check(i, j))
                    result++;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return true;
        if(map[x][y] == 'T') return true;
        if(map[x][y] == 'F') return false;
        if(checked[x][y]) return false;

        checked[x][y] = true;
        boolean result = false;
        if(map[x][y] == 'U') result = check(x + dx[0], y + dy[0]);
        else if(map[x][y] == 'R') result = check(x + dx[1], y + dy[1]);
        else if(map[x][y] == 'D') result = check(x + dx[2], y + dy[2]);
        else if(map[x][y] == 'L') result = check(x + dx[3], y + dy[3]);

        map[x][y] = result ? 'T' : 'F';
        return result;
    }

}