package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main1325 {
    private List<List<Integer>> graph = new ArrayList<>();
    private boolean[] checked;
    private int[] sum;
    private int n;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            BFS(i);
        }

        int max = 0;
        for (int i = 1; i < sum.length; i++) {
            max = Math.max(max, sum[i]);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < sum.length; i++) {
            if(sum[i] == max)
                answer.append(i + " ");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void BFS(int num) {
        checked = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        checked[num] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            List<Integer> list = graph.get(poll);
            for (int i = 0; i < list.size(); i++) {
                if(checked[list.get(i)]) continue;
                checked[list.get(i)] = true;
                q.add(list.get(i));
                sum[list.get(i)]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main1325().solv();
    }
}