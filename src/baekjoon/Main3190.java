package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main3190 {
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};
    private int direction = 0;
    private LinkedList<int[]> snake;
    private Map<Integer, String> dir;
    private int[][] map;
    private int N;
    /*
    처음에 오른쪽을 향함
    벽 또는 자기 자신과 부딪히면 종료
    사과는 맵에서 1

    오른쪽 1, 왼쪽 -1
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dir = new HashMap<>();
        snake = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer tokenizer;
        for (int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = getIntToken(tokenizer) - 1;
            int y = getIntToken(tokenizer) - 1;
            map[x][y] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            dir.put(getIntToken(tokenizer), tokenizer.nextToken());
        }

        int time = move();
        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int move() {
        snake.add(new int[]{0, 0});
        int count = 0;

        while (true) {
            count++;

            int nx = snake.getLast()[0] + dx[direction];
            int ny = snake.getLast()[1] + dy[direction];
            if (isFinish(nx, ny)) break;

            snake.addLast(new int[]{nx, ny});
            if(map[nx][ny] != 1) snake.removeFirst();
            else map[nx][ny] = 0;

            if (dir.containsKey(count)) {
                if (dir.get(count).equals("D")) {
                    direction = (direction + 1) % 4;
                } else{
                    direction = (direction + 3) % 4;
                }
            }
        }

        return count;
    }

    private boolean isFinish(int nx, int ny) {
        if(nx >= N || nx < 0 || ny >= N || ny < 0) return true;
        for (int[] s : snake) {
            if(s[0] == nx && s[1] == ny) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Main3190().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
