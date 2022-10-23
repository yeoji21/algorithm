package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2252 {
    private static int[] edgeCount;
    private static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int M = getIntToken(tokenizer);
        edgeCount = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int first = getIntToken(tokenizer);
            int second = getIntToken(tokenizer);
            graph.get(first).add(second);
            edgeCount[second]++;
        }
        topologicalSort(N);
    }

    private static void topologicalSort(int N) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if(edgeCount[i] == 0)
                queue.add(i);
        }

        StringBuilder answer = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer studentNumber = queue.poll();
            answer.append(studentNumber).append(" ");
            for (Integer next : graph.get(studentNumber)) {
                edgeCount[next]--;
                if(edgeCount[next] == 0)
                    queue.add(next);
            }
        }
        System.out.println(answer);
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}