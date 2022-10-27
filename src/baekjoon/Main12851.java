package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12851 {
    private int answer = 0;
    private int routes = 0;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);

        BFS(N, K);
        bw.write(answer + "\n" + routes + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void BFS(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[100_001];
        queue.add(n);
        visited[n] = 1;

        int times = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int poll = queue.poll();
                if(poll == k){
                    answer = times;
                    routes++;
                    continue;
                }

                int[] arr = new int[]{poll + 1, poll - 1, poll * 2};
                for (int next : arr) {
                    if(next < 0 || next > 100_000) continue;

                    if(visited[next] == 0 || visited[next] == visited[poll] + 1){
                        queue.add(next);
                        visited[next] = visited[poll] + 1;
                    }
                }
            }
            if(answer != 0) {
                break;
            }
            times++;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main12851().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
