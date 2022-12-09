package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2580 {
    private int[][] map;
    private List<int[]> zeros;
    private boolean finish = false;
    private int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
    private int[] dy = {1, 0, -1, 1, 0, -1, 1, 0, -1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        zeros = new ArrayList<>();
        StringTokenizer tokenizer;
        for (int i = 0; i < 9; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = getIntToken(tokenizer);
                if(map[i][j] == 0) zeros.add(new int[]{i, j});
            }
        }

        DFS(0);
    }

    private void DFS(int depth) {
        if(finish) return;
        if (depth == zeros.size()) {
            finish = true;
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    answer.append(map[i][j] + " ");
                }
                answer.append("\n");
            }
            System.out.println(answer.toString());
            return;
        }

        int[] now = zeros.get(depth);

        for (int i = 1; i < 10; i++) {
            if(!checkNumber(now[0], now[1], i)) continue;
            map[now[0]][now[1]] = i;
            DFS(depth + 1);
            map[now[0]][now[1]] = 0;
        }
    }

    private boolean checkNumber(int x, int y, int target) {
        for (int i = 0; i < 9; i++) {
            if(map[x][i] == target) return false;
            if(map[i][y] == target) return false;
        }

        int cx = (x / 3) * 3 + 1;
        int cy = (y / 3) * 3 + 1;
        for (int d = 0; d < 9; d++) {
            int nx = cx + dx[d];
            int ny = cy + dy[d];
            if(map[nx][ny] == target) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main2580().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}