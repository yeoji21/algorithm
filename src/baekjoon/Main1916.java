package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1916 {
    private static List<List<Node>> nodeList = new ArrayList<>();
    private static int[] distance;
    private static boolean[] checked;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        distance = new int[N + 1];
        checked = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < N + 1; i++) {
            nodeList.add(i, new ArrayList<>());
        }

        StringTokenizer tokenizer;
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int from = getIntToken(tokenizer);
            int to = getIntToken(tokenizer);
            int weight = getIntToken(tokenizer);
            Node node = new Node(to, weight);
            nodeList.get(from).add(node);
        }

        tokenizer = new StringTokenizer(br.readLine());
        int from = getIntToken(tokenizer);
        int to = getIntToken(tokenizer);

        System.out.println(dijkstra(from, to));
    }

    private static int dijkstra(int from, int to) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.weight));
        queue.add(new Node(from, 0));
        distance[from] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if(checked[poll.to]) continue;
            checked[poll.to] = true;
            for (Node node : nodeList.get(poll.to)) {
                if(poll.weight + node.weight < distance[node.to]) {
                    distance[node.to] = poll.weight + node.weight;
                    queue.add(new Node(node.to, distance[node.to]));
                }
            }
        }
        return distance[to];
    }

    static class Node{
        private int to;
        private int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
