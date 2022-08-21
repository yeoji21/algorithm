package programmers_level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution2(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) queue.add(scoville[i]);

        if(queue.peek() >= K) return answer;

        while (queue.size() >= 2) {
            Integer last = queue.poll();
            Integer secondLast = queue.poll();
            queue.add(last + secondLast * 2);
            answer++;
            if(queue.peek() >= K) return answer;
        }

        return -1;
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(queue::add);

        int count = 0;
        boolean allClear = false;
        while (!queue.isEmpty()) {
            if(queue.peek() >= K){
                allClear = true;
                break;
            }
            Integer smallest = queue.poll();
            if(queue.isEmpty()) break;
            Integer secondSmallest = queue.poll();
            queue.add(smallest + (secondSmallest * 2));
            count++;
        }

        return allClear ? count : -1;
    }
}
