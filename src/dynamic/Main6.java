package dynamic;

import java.util.*;

public class Main6 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] times = new int[m + 1];
        int[] probScore = new int[n];
        int[] probTime = new int[n];

        for (int i = 0; i < n; i++) {
            probScore[i] = sc.nextInt();
            probTime[i] = sc.nextInt();
        }

        new Main6().solution(times, probScore, probTime);
    }

    public void solution(int[] times, int[] probScore, int[] probTime) {
        for (int i = 0; i < probTime.length; i++) {
            for (int j = times.length-1; j >= probTime[i]; j--) {
                times[j] = Math.max(times[j - probTime[i]] + probScore[i], times[j]);
            }
        }
//        Arrays.stream(times).forEach(x -> System.out.print(x + " "));
        System.out.println(times[times.length-1]);
    }
}
