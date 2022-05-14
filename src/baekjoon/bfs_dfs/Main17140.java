package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17140 {
    private static final int LIMIT = 100;
    private static int[][] map = new int[LIMIT][LIMIT];
    private static int R, C, K;
    private static int rowSize = 3, colSize = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = getIntToken(st) - 1;
        C = getIntToken(st) - 1;
        K = getIntToken(st);

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = getIntToken(st);
            }
        }

        calculate();
    }

    private static void calculate() {
        int time = 0;

        while(map[R][C] != K && ++time <= LIMIT){
            if (rowSize >= colSize) {
                for (int i = 0; i < rowSize; i++)
                    rowSort(i);
            }
            else{
                for (int i = 0; i < colSize; i++)
                    colSort(i);
            }
        }
        System.out.println(time > LIMIT  ? -1 : time);
    }

    private static void rowSort(int row) {
        PriorityQueue<Count> queue = new PriorityQueue<>(Comparator.comparing(Count::getCount).thenComparing(Count::getNum));
        Map<Integer, Integer> counter = new HashMap<>();

        for (int col = 0; col < colSize; col++) {
            if(map[row][col] == 0) continue;
            counter.put(map[row][col], counter.getOrDefault(map[row][col], 0) + 1);
        }
        counter.forEach((K, V) -> queue.add(new Count(K, V)));

        int newColSize = 0;
        while (!queue.isEmpty()) {
            Count count = queue.poll();
            map[row][newColSize++] = count.getNum();
            map[row][newColSize++] = count.getCount();
        }

        colSize = Math.max(colSize, newColSize);
        while (newColSize < LIMIT) map[row][newColSize++] = 0;
    }

    private static void colSort(int col) {
        PriorityQueue<Count> queue = new PriorityQueue<>(Comparator.comparing(Count::getCount).thenComparing(Count::getNum));
        Map<Integer, Integer> counter = new HashMap<>();

        for (int row = 0; row < rowSize; row++) {
            if(map[row][col] == 0) continue;
            counter.put(map[row][col], counter.getOrDefault(map[row][col], 0) + 1);
        }
        counter.forEach((K, V) -> queue.add(new Count(K, V)));

        int newRowSize = 0;
        while (!queue.isEmpty()) {
            Count count = queue.poll();
            map[newRowSize++][col] = count.getNum();
            map[newRowSize++][col] = count.getCount();
        }

        rowSize = Math.max(rowSize, newRowSize);
        while (newRowSize < LIMIT) map[newRowSize++][col] = 0;
    }



    private static class Count{

        int num, count;
        public Count(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }

    }
    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}