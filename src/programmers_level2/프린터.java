package programmers_level2;

import java.util.*;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int priority : priorities) queue.add(priority);
        int idx = 0;
        int answer = 1;
        while (!queue.isEmpty()) {
            Integer max = queue.poll();
            while (priorities[idx] < max) {
                idx++;
                if(idx >= priorities.length) idx = 0;
            }
            if(idx == location) return answer;
            answer++;
            priorities[idx] = -1;
        }

        return -1;
    }

    public static int solution2(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        int result = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    result++;
                    if(i == location) return result;
                }
            }
        }
        return 0;
    }
}
