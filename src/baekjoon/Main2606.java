package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main2606 {
    private List<List<Integer>> network;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        network = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int lines = Integer.parseInt(br.readLine());

        for (int i = 0; i < N + 1; i++) {
            network.add(i, new ArrayList<>());
        }
        StringTokenizer tokenizer;
        for (int i = 0; i < lines; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = getIntToken(tokenizer);
            int b = getIntToken(tokenizer);

            network.get(a).add(b);
            network.get(b).add(a);
        }

        int count = BFS(1);
        bw.write(count - 1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] checked = new boolean[network.size()];
        queue.add(startNode);
        checked[startNode] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;

            for (Integer nextNode : network.get(poll)) {
                if(checked[nextNode]) continue;
                queue.add(nextNode);
                checked[nextNode] = true;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        new Main2606().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}