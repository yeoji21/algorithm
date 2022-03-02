package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890 {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntegerToken(st);
        L = getIntegerToken(st);
        map = new int[N][N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntegerToken(st);
            }
        }

        for (int i = 0; i < N; i++) {
            if(checkRow(i)) result++;
            if(checkColumn(i)) result++;
        }
        System.out.println(result);
    }

    private static boolean checkRow(int row) {
        boolean[] checked = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];
            if(diff == 0) continue;

            if(Math.abs(diff) > 1) return false;
            else if(diff == 1){
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || checked[i + j]) return false;
                    if(map[row][i] - map[row][i+j] != 1) return false;
                    checked[i + j] = true;
                }
            } else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if(i-j < 0 || checked[i-j]) return false;
                    if (map[row][i] != map[row][i - j] ) return false;
                    checked[i - j] = true;
                }
            }
        }
        return true;
    }

    private static boolean checkColumn(int column) {
        boolean[] checked = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][column] - map[i+1][column];
            if(diff == 0) continue;

            if(Math.abs(diff) > 1) return false;
            else if(diff == 1){
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || checked[i + j]) return false;
                    if(map[i][column] - map[i+j][column] != 1) return false;
                    checked[i + j] = true;
                }
            } else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if(i-j < 0 || checked[i-j]) return false;
                    if (map[i][column] != map[i-j][column] ) return false;
                    checked[i - j] = true;
                }
            }
        }
        return true;
    }

    private static int getIntegerToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
