package programmers_level2;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int s : scoville) queue.add((long)s);
        int answer = 0;

        while (queue.size() >= 2) {
            if(queue.peek() >= K) return answer;

            Long first = queue.poll();
            Long second = queue.poll();
            queue.add(first + second * 2);
            answer++;
        }

        return queue.peek() >= K ? answer : -1;
    }
}
