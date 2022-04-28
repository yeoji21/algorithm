package inflean.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main7 {
    private static int V, E;
    private static int[] unf;
    private static List<Node> edges;

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
        edges.sort(Comparator.comparing(Node::getCost));
        return edges
                .stream()
                .filter(Node::union)
                .mapToInt(Node::getCost)
                .sum();
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Node{
        private int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public boolean union() {
            int fromValue = find(from);
            int toValue = find(to);

            if(fromValue != toValue){
                unf[fromValue] = toValue;
                return true;
            }
            return false;
        }

        private int find(int vertex) {
            if(unf[vertex] == vertex) return vertex;
            else return unf[vertex] = find(unf[vertex]);
        }

        public int getCost() {
            return cost;
        }
    }
}