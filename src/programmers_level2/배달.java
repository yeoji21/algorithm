package programmers_level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        int[][] map = new int[N + 1][N + 1];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(i == j) continue;
                map[i][j] = 500001;
            }
        }

        for (int i = 0; i < road.length; i++) {
            if (map[road[i][0]][road[i][1]] < road[i][2]) continue;
            map[road[i][0]][road[i][1]] = road[i][2];
            map[road[i][1]][road[i][0]] = road[i][2];
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if(i == j) continue;
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < map[1].length; i++) {
            if(map[1][i] <= K) result++;
        }
        return result;
    }

    private int[] distance;
    private Map<Integer, List<Road>> map;

    public int solution2(int N, int[][] road, int K) {
        distance = new int[N + 1];
        for (int i = 2; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        map = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] row : road) {
            Road road1 = new Road(row[0], row[1], row[2]);
            map.get(road1.start).add(road1);
            Road road2 = new Road(row[1], row[0], row[2]);
            map.get(road2.start).add(road2);
        }
        connectRoad(1);

        int answer = 0;
        for (int d : distance) {
            if(d <= K) answer++;
        }
        return answer - 1;
    }

    private void connectRoad(int start) {
        if(!map.containsKey(start)) return;

        List<Road> roads = map.get(start);
        for (Road road : roads) {
            if(distance[road.end] > distance[start] + road.value){
                distance[road.end] = distance[start] + road.value;
                connectRoad(road.end);
            }
        }
    }

    static class Road{
        int start;
        int end;
        int value;

        public Road(int[] row) {
            this.start = Math.min(row[0], row[1]);
            this.end = Math.max(row[0], row[1]);
            this.value = row[2];
        }

        public Road(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
