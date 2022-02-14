package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1780 {
    static int N;
    static int[][] map;
    static int MINUS_ONE = 0;
    static int ZERO = 0;
    static int PLUS_ONE = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        splitMap(0, 0, N);

        System.out.println(MINUS_ONE);
        System.out.println(ZERO);
        System.out.println(PLUS_ONE);
    }

    private static void splitMap(int row, int column, int length) {
        if(mapCheck(row, column, length)){
            increase(map[row][column]);
            return;
        }

        int M = length / 3;

        splitMap(row, column, M);
        splitMap(row, column + M, M);
        splitMap(row, column + 2 * M, M);
        splitMap(row + M, column, M);
        splitMap(row + M, column + M, M);
        splitMap(row + M, column + 2 * M, M);
        splitMap(row + 2 * M, column, M);
        splitMap(row + 2 * M, column + M, M);
        splitMap(row + 2 * M, column + 2 * M, M);
    }

    public static boolean mapCheck(int row, int column, int size) {
        Set<Integer> values = new HashSet<>();
        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                values.add(map[i][j]);
            }
        }
        if(values.size() == 1) return true;
        return false;
    }

    private static void increase(int value) {
        if(value == -1)
            MINUS_ONE++;
        else if(value == 0)
            ZERO++;
        else if(value == 1)
            PLUS_ONE++;
    }
}
