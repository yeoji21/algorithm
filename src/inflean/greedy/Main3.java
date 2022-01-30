package inflean.greedy;

import java.util.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] totalTime = new int[73];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int j = start; j < end; j++) {
                totalTime[j]++;
            }
        }

        new Main3().solution(totalTime);
    }

    public void solution(int[] totalTime) {
        System.out.println(Arrays.stream(totalTime).max().orElse(0));
    }
}

