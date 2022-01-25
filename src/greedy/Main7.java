package greedy;

import java.util.*;

public class Main7 {
    static int[] unf;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) unf[i] = i;

        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            edgeList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        new Main7().solution(edgeList);
    }

    public void solution(List<Edge> edgeList) {
        int sum = 0;
        edgeList.sort(Comparator.comparing(e -> e.cost));
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (union(edge.from, edge.to))
                sum += edge.cost;
        }
        System.out.println(sum);
    }

    private boolean union(int from, int to) {
        int fa = find(from);
        int fb = find(to);
        if (fa != fb) {
            unf[fa] = fb;
            return true;
        }
        else return false;
    }

    private int find(int vertex) {
        if (vertex == unf[vertex]) return unf[vertex];
        else return unf[vertex] = find(unf[vertex]);
    }

    static class Edge{
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

}