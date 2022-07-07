package programmers_level2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        Queue<Literature> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Literature(i, priorities[i]));
        }

        PriorityQueue<Literature> priorityQueue = new PriorityQueue<>(Comparator.comparing((Literature l) -> -l.priority));
        for (int i = 0; i < priorities.length; i++) {
            priorityQueue.add(new Literature(i, priorities[i]));
        }

        int count = 0;
        while (!priorityQueue.isEmpty()) {
            Literature literature = queue.poll();
            if (literature.priority >= priorityQueue.peek().priority) {
                count++;
                priorityQueue.poll();
                if(literature.location == location) return count;
            }
            else{
                queue.add(literature);
            }
        }

        return count;
    }

    public int solution2(int[] priorities, int location) {
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


    class Literature{
        int location;
        int priority;

        public Literature(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
