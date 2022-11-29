package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10451 {
    private List<List<Integer>> graph;
    private boolean[] checked;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            checked = new boolean[num + 1];
            graph = new ArrayList<>();
            for (int i = 0; i < num + 1; i++) {
                graph.add(new ArrayList<>());
            }

            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int i = 1; i < num + 1; i++) {
                graph.get(i).add(getIntToken(tokenizer));
            }
            int count = 0;
            for (int i = 1; i < num + 1; i++) {
                if(DFS(i)) count++;
            }

            answer.append(count + "\n");
        }
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean DFS(int num) {
        if(checked[num]) return false;
        checked[num] = true;
        for (int next : graph.get(num)) {
            if(checked[next]) continue;
            DFS(next);
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main10451().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
