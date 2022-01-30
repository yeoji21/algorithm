package inflean.dfs_bfs;

import java.util.*;

public class Main10 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        map = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        map[0][0] = 1;
        new Main10().solution(0,0);
        System.out.println(count);
    }

    public void solution(int x, int y) {
        if (x == 6 && y == 6) {
            count ++;
            return;
        }
        else{
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 ||nx >=7 || ny<0 ||ny >=7) continue;

                if(map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    solution(nx, ny);
                    map[nx][ny] = 0;
                }
            }
        }
    }
}
