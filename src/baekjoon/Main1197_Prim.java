package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1197_Prim {
    private static List<List<Edge>> edges = new ArrayList<>();
    private static int V;
    private static int E;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        V = getIntToken(tokenizer);
        E = getIntToken(tokenizer);
        for (int i = 0; i < V + 1; i++) {
            edges.add(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int A = getIntToken(tokenizer);
            int B = getIntToken(tokenizer);
            int weight = getIntToken(tokenizer);
            edges.get(A).add(new Edge(B, weight));
            edges.get(B).add(new Edge(A, weight));
        }

        System.out.println(prime(1));
    }

    private static int prime(int startVertex) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(edge -> edge.weight));
        queue.add(new Edge(startVertex, 0));
        boolean[] checked = new boolean[V + 1];
        int answer = 0;

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            if(checked[poll.to]) continue;
            checked[poll.to] = true;
            answer += poll.weight;

            for (Edge edge : edges.get(poll.to)) {
                if(checked[edge.to]) continue;
                queue.add(edge);
            }
        }

        return answer;
    }

    private static class Edge{
        private int to;
        private int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
