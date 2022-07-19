package programmers_level2;

import java.util.*;

public class 배달_다익스트라 {
    private static List<Edge>[] edgeList;
    private static int[] distance;

    public int solution(int N, int[][] road, int K) {
        int result = 0;
        edgeList = new ArrayList[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < N + 1; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < road.length; i++) {
            edgeList[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            edgeList[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }
        distance[1] = 0;

        dijkstra();

        for (int cost : distance) {
            if(cost <= K) result++;
        }

        return result;
    }

    private void dijkstra() {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing((Edge e) -> e.weight));
        queue.add(new Edge(1, 0));
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int vertex = edge.vertex;
            int weight = edge.weight;

            if(distance[vertex] < weight) continue;

            for (int i = 0; i < edgeList[vertex].size(); i++) {
                int toVertex = edgeList[vertex].get(i).vertex;
                int toWeight = edgeList[vertex].get(i).weight + weight;

                if (distance[toVertex] > toWeight) {
                    distance[toVertex] = toWeight;
                    queue.add(new Edge(toVertex, toWeight));
                }
            }
        }

    }


    class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

