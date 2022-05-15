import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final int width = 12;
    private static final int height = 6;
    private static char[][] map = new char[width][height];
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < width; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(puyoPuyo());
    }

    private static int puyoPuyo() {
        int count = 0;
        while(true){
            boolean flag = false;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if(map[i][j] != '.'){
                        if(boomCheck(map[i][j], i, j))
                            flag = true;
                    }
                }
            }
            if(!flag) return count;
            count++;
            dropPuyo();
        }
    }

    private static boolean boomCheck(char color, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] checked = new boolean[width][height];
        List<Point> puyos = new ArrayList<>();
        queue.add(new Point(x, y));
        puyos.add(new Point(x, y));
        checked[x][y] = true;


        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx >= width || nx < 0 || ny >= height || ny < 0) continue;
                    if(map[nx][ny] != color || checked[nx][ny]) continue;

                    queue.add(new Point(nx, ny));
                    puyos.add(new Point(nx, ny));
                    checked[nx][ny] = true;
                }
            }
        }

        if(puyos.size() >= 4){
            puyos.stream().forEach(puyo -> map[puyo.x][puyo.y] = '.');
            return true;
        }
        return false;
    }

    private static void dropPuyo() {
        for (int j = 0; j < height; j++) {
            int empty = -1;
            for (int i = width - 1; i >= 0; i--) {
                if(map[i][j] != '.' && empty == -1) continue;
                else if(map[i][j] == '.' && empty == -1) empty = i;
                else if(map[i][j] != '.' && empty != -1){
                    map[empty][j] = map[i][j];
                    map[i][j] = '.';
                    empty--;
                }
            }
        }

    }

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}