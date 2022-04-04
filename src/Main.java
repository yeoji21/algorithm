import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int V, E;
    static int[] unf;
    static List<Node> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = getIntToken(st);
        E = getIntToken(st);

        unf = new int[V + 1];
        IntStream.range(1, V + 1).forEach(i -> unf[i] = i);
        edges = new ArrayList<>(E + 10);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Node(getIntToken(st), getIntToken(st), getIntToken(st)));
        }

        System.out.println(unionFind());
    }

    private static int unionFind() {
        edges.sort(Comparator.comparing(e -> e.cost));
        int sum = 0;

        for (int i = 0; i < edges.size(); i++) {
            Node node = edges.get(i);
            if(union(node.from, node.to))
                sum += node.cost;
        }

        return sum;
    }

    private static boolean union(int from, int to) {
        int fromValue = find(from);
        int toValue = find(to);
        if (fromValue != toValue) {
            unf[toValue] = fromValue;
            return true;
        }
        return false;
    }

    private static int find(int vertex) {
        if(unf[vertex] == vertex) return vertex;
        else return unf[vertex] = find(unf[vertex]);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Node{
        int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}