import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    static int result = 0;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

//        puyoPuyo();
    }

    private static void puyoPuyo() {
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
//                int cnt = 0;
//                while(BFS(i, j)){cnt++;}
//                if(cnt > 0) result++;
                if (BFS(i, j)) result++;
            }
        }
        System.out.println(result);
    }

    private static boolean BFS(int i, int j) {
        int cnt = 0;
        boolean[][] checked = new boolean[12][6];
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(i, j));
        checked[i][j] = true;
        int[] columns = new int[6];
        List<Point> boom = new ArrayList<>();

        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            while (--size >= 0) {
                Point now = queue.poll();
                System.out.println("now : " + map[now.x][now.y]);
                columns[now.y]++;

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx < 0|| ny < 0|| nx >=12 || ny >= 6) continue;
                    if(checked[nx][ny] || map[now.x][now.y] != map[nx][ny]) continue;

                    queue.add(new Point(nx, ny));
                    checked[nx][ny] = true;
                }
            }
        }

        System.out.println("*****************");
        boom.forEach(System.out::println);

        if(cnt < 4) return false;

//        boom.forEach(p -> columns[p.y]++);

        IntStream.range(0, 6).filter(idx -> columns[idx] > 0)
                .forEach(idx -> {
                    int columnCount = columns[idx];
                    System.out.println(columnCount);
                    char[] saveRow = new char[12 - columnCount];
                    for (int l = 0; l < saveRow.length; l++) saveRow[l] = map[l][idx];

                    for (int l = columnCount; l < 12; l++)
                        map[l][idx] = saveRow[l];
                });

        return true;
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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