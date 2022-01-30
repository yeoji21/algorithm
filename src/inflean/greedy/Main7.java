package inflean.greedy;

import java.util.*;

public class Main7 {
    static int[] unf;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        initializeUnionArr(v);
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < e; i++)
            edgeList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));

        new Main7().solution(edgeList);
    }

    public void solution(List<Edge> edgeList) {
        edgeList.sort(Comparator.comparing(e -> e.cost));

        System.out.println(edgeList.stream().filter(edge -> union(edge.from, edge.to))
                                            .mapToInt(edge -> edge.cost)
                                            .sum());
    }

    private boolean union(int from, int to) {
        int findIdxFrom = find(from);
        int findIdxTo = find(to);

        if (findIdxFrom != findIdxTo) {
            unf[findIdxFrom] = findIdxTo;
            return true;
        }
        else return false;
    }

    private int find(int vertex) {
        if (vertex == unf[vertex]) return unf[vertex];
        else return unf[vertex] = find(unf[vertex]);
    }

    private static void initializeUnionArr(int size) {
        unf = new int[size + 1];
        for (int i = 1; i <= size; i++) unf[i] = i;
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