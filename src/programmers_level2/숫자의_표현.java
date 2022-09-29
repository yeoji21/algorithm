package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자의_표현 {
    public int solution(int n) {
        int count = 0;

        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = i; j < n + 1; j++) {
                sum += j;
                if (sum == n) {
                    count++;
                    break;
                }
                else if (sum > n)
                    break;
            }
        }

        return count;
    }

    public int solution2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int answer = 1;

        for (int i = 1; i < n; i++) {
            while (sum >= n) {
                if(sum == n) answer++;
                sum -= queue.poll();
            }
            queue.add(i);
            sum += i;
        }

        while (sum >= n) {
            if(sum == n) answer++;
            sum -= queue.poll();
        }

        return answer;
    }
}
