package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1260 {
    public static void main(String[] args) throws Exception {
        new Main1260().solv();
    }

    private List<List<Integer>> nodes = new ArrayList<>();
    private StringBuilder answer = new StringBuilder();
    private void solv() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int edgeCount = getIntToken(tokenizer);
        int startNode = getIntToken(tokenizer);

        for (int i = 0; i < N + 1; i++) {
            nodes.add(0, new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = getIntToken(tokenizer);
            int b = getIntToken(tokenizer);
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(nodes.get(i));
        }

        DFS(startNode, new boolean[N + 1]);
        answer.append("\n");
        BFS(startNode, new boolean[N + 1]);
        System.out.println(answer.toString());
    }

    private void BFS(int startNode, boolean[] checked) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        checked[startNode] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            answer.append(node).append(" ");

            for (Integer nextNode : nodes.get(node)) {
                if(checked[nextNode]) continue;
                checked[nextNode] = true;
                queue.add(nextNode);
            }
        }
    }

    private void DFS(int startNode, boolean[] checked) {
        if(checked[startNode]) return;
        answer.append(startNode).append(" ");
        checked[startNode] = true;
        for (Integer nextNode : nodes.get(startNode)) {
            DFS(nextNode, checked);
        }
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
