import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static List<List<Node>> edgeList = new LinkedList<>();
    static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = getIntToken(st);
        int M = getIntToken(st);
        for (int i = 0; i <= N; i++) edgeList.add(new LinkedList<>());
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = getIntToken(st);
            int to = getIntToken(st);
            int weight = getIntToken(st);

            edgeList.get(from).add(new Node(to, weight));
        }

        move(1);

        IntStream.range(2, N + 1).forEach(i -> {
            if (distance[i] == Integer.MAX_VALUE)
                System.out.println(i + " : impossible");
            else
                System.out.println(i + " : " + distance[i]);
        });
    }

    private static void move(int startNode) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>(Comparator.comparing(node -> -node.weight));
        queue.add(new Node(startNode, 0));
        distance[startNode] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowNode = now.vertex;
            int weight = now.weight;
            if(weight > distance[nowNode]) continue;
            edgeList.get(nowNode).stream().forEach(node -> {
                int newWeight = node.weight + weight;
                if(distance[node.vertex] > newWeight) {
                    distance[node.vertex] = newWeight;
                    queue.add(new Node(node.vertex, newWeight));
                }
            });
        }
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Node{
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}