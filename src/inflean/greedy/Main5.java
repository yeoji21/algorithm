package inflean.greedy;

import java.util.*;
import java.util.stream.IntStream;

public class Main5 {
    static int n, m;
    static List<List<Edge>> edgeList;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        edgeList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
        }

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            edgeList.get(from).add(new Edge(to, cost));
        }

        new Main5().solution(1);

        IntStream.range(2, n+1).forEach(i -> {
            if (distance[i] == Integer.MAX_VALUE)
                System.out.println(i + " : impossible");
            else
                System.out.println(i + " : " + distance[i]);
        });
    }

    public void solution(int vertex) {
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparing(e -> -e.cost));
        queue.add(new Edge(vertex, 0));
        distance[vertex] = 0;

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int nowVertex = now.vertex;
            int nowCost = now.cost;
            if (nowCost > distance[nowVertex]) continue;
            for (Edge edge : edgeList.get(nowVertex)) {
                int newCost = nowCost + edge.cost;
                if (distance[edge.vertex] > newCost) {
                    distance[edge.vertex] = newCost;
                    queue.add(new Edge(edge.vertex, newCost));
                }
            }
        }
    }

    static class Edge {
        int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex=" + vertex +
                    ", cost=" + cost +
                    '}';
        }
    }
}
