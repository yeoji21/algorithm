package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11657 {
    private static Bus[] buses;
    private static long[] distance;
    private static int N;
    private static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        buses = new Bus[M];
        distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            buses[i] = new Bus(getIntToken(tokenizer), getIntToken(tokenizer), getIntToken(tokenizer));
        }

        if(bellmanFord()) {
            System.out.println(-1);
            return;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 2; i < distance.length; i++) {
            answer.append(distance[i] == Long.MAX_VALUE ? -1 : distance[i]).append("\n");
        }
        System.out.println(answer.toString());
    }

    private static boolean bellmanFord() {
        distance[1] = 0;
        for (int i = 0; i < N; i++) {
            for (Bus bus : buses) {
                if(distance[bus.from] == Long.MAX_VALUE) continue;

                if(distance[bus.to] > distance[bus.from] + bus.cost){
                    distance[bus.to] = distance[bus.from] + bus.cost;
                    if(i == N - 1) return true;
                }
            }
        }
        return false;
    }

    private static class Bus{
        int from;
        int to;
        int cost;

        public Bus(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
