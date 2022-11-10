import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//https://buddev.tistory.com/31

public class Main {
    private Horse[] horses;
    private LinkedList<Integer>[][] orders;
    private int[][] map;
    private int[] dx = {0, -1, 1, 0, 0};
    private int[] dy = {0, 0, 0, -1, 1};
    private int N, K;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        K = getIntToken(tokenizer);
        horses = new Horse[K + 1];
        map = new int[N][N];
        orders = new LinkedList<>[N][N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntToken(tokenizer);
                orders[i][j] = new LinkedList<>();
            }
        }

        for (int i = 1; i < K + 1; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = getIntToken(tokenizer);
            int y = getIntToken(tokenizer);
            int d = getIntToken(tokenizer);
            horses[i] = new Horse(x, y, d);
            orders[x][y].add(i);
        }


        int answer;
        for (answer = 1; answer <= 1000; answer++) {
            for (int i = 1; i < K + 1; i++) {
                Horse horse = horses[i];
                int nx = horse.x + dx[horse.d];
                int ny = horse.y + dy[horse.d];

                boolean end = false;
                if(nx >= N || nx < 0 || ny >= N || ny < 0)
                    end = blue(horse, nx, ny);

                int color = map[nx][ny];
                int order = getOrder(i, horse);
                if(color == 0) {
                    end = white(horse, order, nx, ny);
                }
                else if(color == 1)
                    end = red(horse, order, nx, ny);
                else if(color == 2)
                    end = blue(horse, nx, ny);

                if(end) {
                    System.out.println(answer);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    private boolean blue(Horse horse, int x, int y) {



        return false;
    }

    private boolean red(Horse horse, int order, int nx, int ny) {
        while (orders[horse.x][horse.y].size() >= order) {
            int removed = orders[horse.x][horse.y].removeLast();
            horses[removed].x = nx;
            horses[removed].y = ny;
            orders[nx][ny].add(removed);
        }
        return orders[nx][ny].size() >= 4;
    }

    private boolean white(Horse horse, int order, int nx, int ny) {
        while (orders[horse.x][horse.y].size() >= order) {
            int removed = orders[horse.x][horse.y].remove(order);
            horses[removed].x = nx;
            horses[removed].y = ny;
            orders[nx][ny].add(removed);
        }
        return orders[nx][ny].size() >= 4;
    }

    private int getOrder(int num, Horse horse) {
        List<Integer> order = orders[horse.x][horse.y];
        for (int i = 0; i < order.size(); i++) {
            if(order.get(i) == num) return i;
        }
        throw new IllegalArgumentException();
    }

    static class Horse{
        int x, y, d;

        public Horse(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}