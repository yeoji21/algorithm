package inflean.greedy;

import java.util.*;

public class Main7_1 {
    static int[] checked;
    static List<List<Edge>> edgeList;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        initializeCheckedArr(v);
        initializeEdgeList(v);

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edgeList.get(a).add(new Edge(b, c));
            edgeList.get(b).add(new Edge(a, c));
        }

        new Main7_1().solution(1);
    }

    public void solution(int vertex) {
        int result = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        queue.add(new Edge(vertex, 0));

        while (!queue.isEmpty()) {
            Edge removed = queue.remove();
            int removedVertex = removed.vertex;
            if (checked[removedVertex] == 0) {
                checked[removedVertex] = 1;
                result += removed.cost;
                for (Edge edge : edgeList.get(removedVertex)) {
                    if(checked[edge.vertex] == 0) queue.add(edge);
                }
            }
        }
        System.out.println(result);
    }

    static class Edge{
        int vertex, cost;
        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

    }
    private static void initializeCheckedArr(int size) {
        checked = new int[size + 1];
    }
    private static void initializeEdgeList(int size) {
        edgeList = new ArrayList<>();
        for (int i = 0; i <= size; i++) edgeList.add(new ArrayList<>());
    }
}
