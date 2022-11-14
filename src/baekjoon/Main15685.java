package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15685 {
    private boolean[][] map;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new boolean[101][101];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = getIntToken(tokenizer);
            int y = getIntToken(tokenizer);
            int d = getIntToken(tokenizer);
            int g = getIntToken(tokenizer);
            curve(x, y, d, g);
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void curve(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = directions.size() - 1; j >= 0; j--) {
                directions.add((directions.get(j) + 1) % 4);
            }
        }
        map[y][x] = true;
        for (int i = 0; i < directions.size(); i++) {
            x += dx[directions.get(i)];
            y += dy[directions.get(i)];
            map[y][x] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main15685().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
