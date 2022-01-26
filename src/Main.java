import java.util.*;

public class Main {
    static int[] checked;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        checked = new int[v + 1];
        List<List<Edge>> edgeList = new ArrayList<>();
        for (int i = 0; i <= v; i++) edgeList.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edgeList.get(a).add(new Edge(b, c));
            edgeList.get(b).add(new Edge(a, c));
        }

        new Main().solution(edgeList);
    }

    public void solution(List<List<Edge>> edgeList) {
        int result = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        queue.add(new Edge(1, 0));
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
}

class Edge{
    int vertex, cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}