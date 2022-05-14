package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890 {
    private static int N, L;
    private static int[][] map;
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);
        L = getIntToken(st);

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = getIntToken(st);
        }

        for (int i = 0; i < N; i++) {
            rowCheck(i);
            columnCheck(i);
        }

        System.out.println(result);
    }

    private static void rowCheck(int row) {
        boolean[] checked = new boolean[N];

        for (int col = 0; col < N - 1; col++) {
            int diff = map[row][col] - map[row][col + 1];
            if(diff == 0 ) continue;
            if (Math.abs(diff) >= 2) return;
            if (diff == -1) {
                for (int l = 0; l < L; l++) {
                    if (col - l < 0 || checked[col - l]) return;
                    if (map[row][col] != map[row][col - l]) return;
                    checked[col - l] = true;
                }
            }
            if (diff == 1) {
                for (int l = 1; l <= L; l++) {
                    if (col + l >= N || checked[col + l]) return;
                    if (map[row][col] - map[row][col + l] != 1) return;
                    checked[col + l] = true;
                }
            }
        }

        result++;
    }

    private static void columnCheck(int col) {
        boolean[] checked = new boolean[N];

        for (int row = 0; row < N - 1; row++) {
            int diff = map[row][col] - map[row + 1][col];
            if(diff == 0 ) continue;

            if (Math.abs(diff) >= 2) return;
            if (diff == -1) {
                for (int l = 0; l < L; l++) {
                    if (row - l < 0 || checked[row - l]) return;
                    if (map[row][col] != map[row - l][col]) return;
                    checked[row - l] = true;
                }
            }
            if (diff == 1) {
                for (int l = 1; l <= L; l++) {
                    if (row + l >= N || checked[row + l]) return;
                    if (map[row][col] - map[row + l][col] != 1) return;
                    checked[row + l] = true;
                }
            }
        }

        result++;
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}