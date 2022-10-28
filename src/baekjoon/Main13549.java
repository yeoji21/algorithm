package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13549 {
    private int[] jump = {1, 1, 0};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);

        bw.write(BFS(N, K) - 1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private int BFS(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int[] times = new int[100_001];
        times[n] = 1;

        while (!queue.isEmpty()) {
            int location = queue.poll();
            if(location == k)
                return times[location];

            int[] next = {location - 1, location + 1, location * 2};
            for (int i = 0; i < next.length; i++) {
                int nextLocation = next[i];
                if(nextLocation > 100_000 || nextLocation < 0) continue;
                if(times[nextLocation] != 0 && times[nextLocation] < times[location] + jump[i]) continue;
                times[nextLocation] = times[location] + jump[i];
                queue.add(nextLocation);
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Main13549().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
