package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13913 {
    private int[] root;
    private int[] times;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);

        if(N > K){
            bw.write(N - K + "\n");
            StringBuilder sb = new StringBuilder();
            for (int i = N; i >= K; i--) {
                sb.append(i).append(" ");
            }
            bw.write(sb.toString() + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        root = new int[100_001];
        times = new int[100_001];

        BFS(N, K);
        bw.write(times[K] - 1 + "\n");
        StringBuilder sb = new StringBuilder();
        sb.append(K).append(" ");
        int idx = K;
        while (idx != N) {
            sb.insert(0, root[idx] + " ");
            idx = root[idx];
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void BFS(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        root[n] = n;
        times[n] = 1;

        while (!queue.isEmpty()) {
            int location = queue.poll();
            if(location == k) return;

            int[] nextLocations = {location - 1, location + 1, location * 2};
            for (int nextLocation : nextLocations) {
                if(nextLocation > 100_000 || nextLocation < 0) continue;
                if(times[nextLocation] != 0) continue;

                times[nextLocation] = times[location] + 1;
                root[nextLocation] = location;
                queue.add(nextLocation);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main13913().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
