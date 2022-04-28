package inflean.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main7_1 {
    private static List<List<Edge>> edges;
    private static boolean[] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = getIntegerToken(st);
        int E = getIntegerToken(st);
        checked = new boolean[V + 1];

        edges = new ArrayList<>(V + 10);
        for (int i = 0; i < V + 1; i++)
            edges.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = getIntegerToken(st);
            int to = getIntegerToken(st);
            int cost = getIntegerToken(st);

            edges.get(from).add(new Edge(to, cost));
            edges.get(to).add(new Edge(from, cost));
        }

        startFromVertex(1);
    }

    private static void startFromVertex(int vertex) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(Edge::getCost));
        queue.add(new Edge(vertex, 0));
        int result = 0;

        while (!queue.isEmpty()) {
            Edge findVertex = queue.poll();
            int toVertex = findVertex.vertex;

            if (!checked[toVertex]) {
                checked[toVertex] = true;
                result += findVertex.cost;
                edges.get(toVertex)
                        .stream()
                        .filter(edge -> !checked[edge.vertex])
                        .forEach(queue::add);
            }
        }
        System.out.println(result);
    }

    private static int getIntegerToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Edge{
        private int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }
}