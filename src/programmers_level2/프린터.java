package programmers_level2;

import java.util.*;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(i);
        }

        int answer = 0;
        while (!q.isEmpty()) {
            int poll = q.poll();
            if (!pq.isEmpty() && priorities[poll] == pq.peek()) {
                answer++;
                pq.poll();
                if(poll == location) return answer;
            }
            else{
                q.add(poll);
            }
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
