import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;
    public static void main(String[] args) throws Exception {
        map = new int[7][7];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[0][0] = 1;
        DFS(0, 0);
        System.out.println(result);
    }

    private static void DFS(int x, int y) {
        if(x == 6 && y == 6){
            result++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= 7 || ny >= 7) continue;
            if(map[nx][ny] == 1) continue;
            map[nx][ny] = 1;
            DFS(nx, ny);
            map[nx][ny] = 0;
        }
    }
}