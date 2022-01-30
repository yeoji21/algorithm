package inflean.dfs_bfs;

import java.util.*;

public class Main3 {
    static int[] scores, times;
    static int limitTime;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        limitTime = sc.nextInt();
        scores = new int[n];
        times = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        new Main3().solution(0, 0, 0);
        System.out.println(result);
    }

    public void solution(int level, int totalTime, int totalScore) {
        if(totalTime > limitTime) return;
        if(level == scores.length){
            result = Math.max(result, totalScore);
            return;
        }
        else{
            solution(level+1, totalTime+times[level],totalScore+scores[level]);
            solution(level+1, totalTime, totalScore);
        }
    }
}