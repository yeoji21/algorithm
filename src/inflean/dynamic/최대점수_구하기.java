package inflean.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수_구하기 {
    private static int N, T;
    private static Problem[] problems;
    private static int[] times;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);
        T = getIntToken(st);
        problems = new Problem[N];
        times = new int[T + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(getIntToken(st), getIntToken(st));
        }

        for (int i = 0; i < problems.length; i++) {
            for (int j = times.length - 1; j >= problems[i].time; j--) {
                times[j] = Math.max(times[j], times[j - problems[i].time] + problems[i].score);
            }
        }

        System.out.println(times[T]);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static class Problem{
        private int score, time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
