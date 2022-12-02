package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main5567 {
    private boolean[] checked;
    private List<List<Integer>> graph;
    private int N, M;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        checked = new boolean[N + 1];
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = getIntToken(tokenizer);
            int b = getIntToken(tokenizer);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int answer = BFS();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        checked[1] = true;
        int answer = 0;
        int depth = 0;
        while (!q.isEmpty()) {
            if(depth == 2) break;
            int size = q.size();
            while (size-- > 0) {
                int poll = q.poll();

                for (int i = 0; i < graph.get(poll).size(); i++) {
                    int friend = graph.get(poll).get(i);
                    if(checked[friend]) continue;
                    checked[friend] = true;
                    answer++;
                    q.add(friend);
                }
            }
            depth++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        new Main5567().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
