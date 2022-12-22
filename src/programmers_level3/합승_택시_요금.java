package programmers_level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 합승_택시_요금 {
    private int N, E;
    private int[][] map;
    private boolean[] checked;
    private PriorityQueue<int[]> q;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        E = fares.length;
        map = new int[n][n];

        for(int i = 0; i < E; i++){
            int start = fares[i][0] - 1;
            int end = fares[i][1] - 1;
            int cost = fares[i][2];
            map[start][end] = cost;
            map[end][start] = cost;
        }

        int[] together = dijkstra(s - 1);
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i ++){
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a - 1] + alone[b - 1];
            if(cost < answer) answer = cost;
        }

        return answer;
    }

    int[] dijkstra(int start){
        q = new PriorityQueue<>(Comparator.comparing(r -> r[0]));
        checked = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        q.add(new int[]{0, start});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int s = now[1];
            if(checked[s]) continue;
            checked[s] = true;
            for(int e = 0; e < N; e++){
                if(map[s][e] == 0) continue;

                if(distance[s] + map[s][e] < distance[e]){
                    distance[e] = distance[s] + map[s][e];
                    q.add(new int[]{distance[e], e});
                }
            }
        }
        return distance;
    }
}
