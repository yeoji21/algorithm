package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main1197_Union {
    private static List<Edge> edges;
    private static int V;
    private static int E;
    private static int[] unf;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        V = getIntToken(tokenizer);
        E = getIntToken(tokenizer);
        unf = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            unf[i] = i;
        }
        edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int A = getIntToken(tokenizer);
            int B = getIntToken(tokenizer);
            int weight = getIntToken(tokenizer);
            edges.add(new Edge(A, B, weight));
        }
        System.out.println(unionFind());
    }

    private static int unionFind() {
        edges.sort(Comparator.comparing(edge -> edge.weight));
        int answer = 0;
        for (Edge edge : edges) {
            if(edge.union()) answer += edge.weight;
        }
        return answer;
    }

    private static class Edge{
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public boolean union() {
            int from = find(this.from);
            int to = find(this.to);
            if(from == to) return false;
            unf[from] = to;
            return true;
        }

        private int find(int vertex) {
            if(unf[vertex] == vertex) return vertex;
            return unf[vertex] = find(unf[vertex]);
        }
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
