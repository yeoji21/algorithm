import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private int[] distance;
    private Map<Integer, List<Road>> map;

    public int solution(int N, int[][] road, int K) {
        distance = new int[N + 1];
        for (int i = 2; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        map = new HashMap<>();
        for (int[] row : road) {
            Road newRoad = new Road(row);
            if(!map.containsKey(newRoad.start))
                map.put(newRoad.start, new ArrayList<>());
            map.get(newRoad.start).add(newRoad);
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
            if(distance[start] > distance[road.end] + road.value){
                distance[start] = distance[road.end] + road.value;
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
    }
}
