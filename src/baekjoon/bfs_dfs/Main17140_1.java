package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17140_1 {
    static int R, C, K;
    static final int LIMIT = 100;
    static int[][] map = new int[LIMIT][LIMIT];
    static int ROW_SIZE = 3, COL_SIZE = 3;

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
            if(ROW_SIZE >= COL_SIZE)
                for (int i = 0; i < ROW_SIZE; i++)
                    RSort(i);
            else
                for (int i = 0; i < COL_SIZE; i++)
                    CSort(i);

        }
        return time > LIMIT ? -1 : time;
    }

    private static void RSort(int key) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Map<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < COL_SIZE; i++) {
            if(map[key][i] == 0) continue;
            dict.put(map[key][i], dict.getOrDefault(map[key][i], 0) + 1);
        }
        dict.forEach((k, v) -> queue.add(new Point(k, v)));

        int i = 0;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            map[key][i++] = poll.num;
            map[key][i++] = poll.count;
        }

        COL_SIZE = Math.max(COL_SIZE, i);

        while(i < LIMIT) map[key][i++] = 0;
    }

    private static void CSort(int key) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Map<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < ROW_SIZE; i++) {
            if(map[i][key] == 0) continue;
            dict.put(map[i][key], dict.getOrDefault(map[i][key], 0) + 1);
        }
        dict.forEach((k, v) -> queue.add(new Point(k, v)));

        int i = 0;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            map[i++][key] = poll.num;
            map[i++][key] = poll.count;
        }

        ROW_SIZE = Math.max(ROW_SIZE, i);

        while(i < LIMIT) map[i++][key] = 0;
    }

    static class Point implements Comparable<Point>{
        int num, count;

        public Point(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            if(this.count > o.count) return 1;
            else if(this.count == o.count) return this.num - o.num;
            else return -1;
        }
    }

    private static int getIntegerToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
