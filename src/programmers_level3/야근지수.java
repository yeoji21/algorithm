package programmers_level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            q.add(works[i]);
        }

        while (n > 0 && !q.isEmpty()) {
            int max = q.poll();
            n--;
            if(max == 1) continue;
            max--;
            q.add(max);
        }

        long answer = 0;
        while (!q.isEmpty()) {
            answer += Math.pow(q.poll(), 2);
        }

        return answer;
    }
}
