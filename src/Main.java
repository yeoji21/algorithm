import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static Point start, dest;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        dest = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));

        BFS();
    }

    private static void BFS() {
        boolean[][][] checked = new boolean[N][M][5];
        int[] dx = {0, 0, 0, 1, -1};
        int[] dy = {0, 1, -1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        checked[start.x][start.y][start.d] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
//            System.out.println(size);
//            System.out.println("************************");
//            queue.stream().forEach(System.out::println);

            while (size-- > 0) {
                Point now = queue.poll();
//                System.out.println(now);

                if(now.x == dest.x && now.y == dest.y && now.d == dest.d) {
                    System.out.println(time);
                    return;
                }

//                if(now.x == dest.x && now.y == dest.y){
//                    if(now.d == dest.d){
//                        System.out.println(time);
//                        return;
//                    }
//                    else{
////                        queue.stream().forEach(System.out::println);
//                        time++;
//                        directionCheck(time, now, dest.d);
//                        System.out.println(time);
//                        return;
//                    }
//                }

                for (int i = 1; i < 5; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(rangeCheck(nx, ny)) continue;
                    if(checked[nx][ny][i] || map[nx][ny] == 1) continue;

                    if (now.d == i) {
                        sameDirection(checked, queue, now);
                    }else{
                        directionCheck(time, now, i);
                        queue.offer(new Point(now.x, now.y, i));
                        checked[now.x][now.y][i] = true;
                    }
                }
            }
        }


    }

    private static void directionCheck(int time, Point now, int i) {
        if(now.d == 1 && i == 2) time++;
        else if(now.d == 2 && i == 1) time++;
        else if(now.d == 3 && i == 4) time++;
        else if(now.d == 4 && i == 3) time++;
    }

    private static void sameDirection(boolean[][][] checked, Queue<Point> queue, Point now) {
        for (int w = 1; w < 4; w++) {
            Point go = go(now, w);
            if(go == null) break;
            if(map[go.x][go.y] != 1 && !checked[go.x][go.y][go.d]){
                queue.offer(go);
                checked[go.x][go.y][go.d] = true;
            }
        }
    }

    private static Point go(Point now, int w) {
        Point temp = new Point(now.x, now.y, now.d);
        if(temp.d == 1){
            temp.y += w;
        } else if (temp.d == 2) {
            temp.y -= w;
        }else if (temp.d == 3) {
            temp.x += w;
        }else if (temp.d == 4) {
            temp.x -= w;
        }
        if(!rangeCheck(temp.x, temp.y))
            return temp;
        return null;
    }

    private static boolean rangeCheck(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }

    static class Point{
        int x, y, d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    '}';
        }
    }
}