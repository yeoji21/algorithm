package programmers;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int result = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            if (budget < 0) break;
            result++;
        }

        return result;
    }



}
