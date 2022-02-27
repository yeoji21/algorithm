package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17140 {
    static final int LIMIT = 100;
    static int COL_SIZE = 3, ROW_SIZE = 3;
    static int[][] map;
    static int R, C, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = getIntegerToken(st)-1;
        C = getIntegerToken(st)-1;
        K = getIntegerToken(st);

        map = new int[LIMIT][LIMIT];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = getIntegerToken(st);
            }
        }
        System.out.println(getTime());
    }

    private static int getTime() {
        int time = 0;
        while (map[R][C] != K && ++time <= LIMIT) {
            if(ROW_SIZE >= COL_SIZE) RSort();
            else CSort();
        }
        return time > LIMIT ? -1 : time;
    }

    private static void RSort() {
        int newColSize = COL_SIZE;

        for (int x = 0; x < ROW_SIZE; x++) {
            Map<Integer, Integer> dict = new HashMap<>();

            for (int y = 0; y < COL_SIZE; y++) {
                if(map[x][y] == 0) continue;

                dict.put(map[x][y], dict.getOrDefault(map[x][y], 0) + 1);
                map[x][y] = 0;
            }
            ArrayList<Map.Entry<Integer, Integer>> dictEntry = dictSort(dict);
            int colSize = Math.min(dictEntry.size() * 2, LIMIT);

            for (int i = 0; i < colSize; i++) {
                Map.Entry<Integer, Integer> value = dictEntry.remove(0);
                map[x][i] = value.getKey();
                map[x][++i] = value.getValue();
            }
            newColSize = Math.max(newColSize, colSize);
        }
        COL_SIZE = Math.max(ROW_SIZE, newColSize);
    }

    private static void CSort() {
        int newRowSize = ROW_SIZE;

        for (int y = 0; y < COL_SIZE; y++) {
            Map<Integer, Integer> dict = new HashMap<>();
            for (int x = 0; x < ROW_SIZE; x++) {
                if(map[x][y] == 0) continue;

                dict.put(map[x][y], dict.getOrDefault(map[x][y], 0) + 1);
                map[x][y] = 0;
            }

            ArrayList<Map.Entry<Integer, Integer>> dictEntry = dictSort(dict);
            int rowSize = Math.min(dictEntry.size() * 2, LIMIT);
            for (int i = 0; i < rowSize; i++) {
                Map.Entry<Integer, Integer> value = dictEntry.remove(0);
                map[i][y] = value.getKey();
                map[++i][y] = value.getValue();
            }
            newRowSize = Math.max(newRowSize, rowSize);
        }
        ROW_SIZE = Math.max(ROW_SIZE, newRowSize);
    }

    private static ArrayList<Map.Entry<Integer, Integer>> dictSort(Map<Integer, Integer> dict) {
        ArrayList<Map.Entry<Integer, Integer>> dictEntry = new ArrayList<>(dict.entrySet());
        dictEntry.sort(Map.Entry.<Integer, Integer>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey()));
        return dictEntry;
    }

    private static int getIntegerToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
