package programmers_level2;

import java.util.ArrayList;
import java.util.List;

public class 줄_서는_방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> nums = new ArrayList<>();

        long factorial = 1;
        for (int i = 1; i < n + 1; i++) {
            nums.add(i);
            factorial *= i;
        }

        int idx = 0;
        long remain = k - 1;

        while (idx < n) {
            factorial = factorial / (n - idx);
            int value = (int) (remain / factorial);
            answer[idx++] = nums.get(value);
            nums.remove(value);
            remain %= factorial;
        }

        return answer;
    }
}
