import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int result = 0;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] checked = new boolean[12][6];
    static int[] columns = new int[6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];

        for (int i = 0; i < 12; i++)
            map[i] = br.readLine().toCharArray();

        puyoPuyo();
    }

    private static void puyoPuyo() {

        while(true) {
            checked = new boolean[12][6];
            columns = new int[6];
            int count = 0;
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if(!checked[i][j] && map[i][j] != '.')
                        if (BFS(i, j)) {
                            count++;
                        }
                }
            }
            if(count == 0) break;
            result++;
            gravity();

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

        System.out.println(result);
    }

    private static boolean BFS(int i, int j) {
        int cnt = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j, map[i][j]));
        checked[i][j] = true;

        int[] columns2 = new int[6];
        columns2[j]++;

        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            while (--size >= 0) {
                Point now = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx < 0|| ny < 0|| nx >= 12 || ny >= 6) continue;
                    if(map[nx][ny] == '.') continue;
                    if(checked[nx][ny] || map[nx][ny] != map[now.x][now.y]) continue;

                    queue.add(new Point(nx, ny, map[nx][ny]));
                    columns2[ny]++;
                    checked[nx][ny] = true;
                }
            }
        }

        if(cnt < 4) return false;
        else{
            for (int x = 0; x < columns2.length; x++) {
                columns[x] += columns2[x];
            }
            return true;
        }
    }

    private static void gravity() {
        IntStream.range(0, 6).filter(idx -> columns[idx] > 0)
                .forEach(idx -> {
                    int columnCount = columns[idx];
                    char[] saveRow = new char[12 - columnCount];
                    for (int l = 0; l < saveRow.length; l++) saveRow[l] = map[l][idx];

                    for (int l = 0; l < saveRow.length; l++)
                        map[l+columnCount][idx] = saveRow[l];
                });
    }

    static class Point{
        int x, y;
        char c;

        public Point(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}