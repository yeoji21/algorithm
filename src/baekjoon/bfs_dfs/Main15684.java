package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main15684 {
    private static int[][] ladder;
    private static int N, M, H;
    private static final int RIGHT = 1, LEFT = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);
        M = getIntToken(st);
        H = getIntToken(st);
        ladder = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = getIntToken(st);
            int y = getIntToken(st);

            ladder[x][y] = RIGHT;
            ladder[x][y + 1] = LEFT;
        }

        for (int i = 0; i < 4; i++) {
            if(cheatingLadder(1, 1, 0, i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static boolean cheatingLadder(int x, int y, int count, int limit) {
        if (count == limit) {
            return ladderCheck();
        }

        for (int i = x; i < H + 1; i++) {
            for (int j = y; j < N; j++) {
                if(ladder[i][j] != 0 || ladder[i][j+1] != 0) continue;
                ladder[i][j] = RIGHT;
                ladder[i][j + 1] = LEFT;

                if (cheatingLadder(i, j + 2, count + 1, limit)) return true;

                ladder[i][j] = 0;
                ladder[i][j + 1] = 0;
            }
            y = 0;
        }
        return false;
    }

    private static boolean ladderCheck() {
        for (int i = 1; i < N + 1; i++) {
            int x = 1, y = i;
            for (int j = 1; j < H + 1; j++) {
                if(ladder[x][y] == RIGHT) y++;
                else if(ladder[x][y] == LEFT) y--;
                x++;
            }
            if(y != i) return false;
        }
        return true;
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}