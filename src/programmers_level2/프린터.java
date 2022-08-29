package programmers_level2;

import java.util.*;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        List<Integer> priority = new ArrayList<>();
        Queue<Literature> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            priority.add(priorities[i]);
            queue.add(new Literature(i, priorities[i]));
        }
        priority.sort(Collections.reverseOrder());

        int count = 0;
        while (!queue.isEmpty()){
            Integer p = priority.get(0);
            Literature poll = queue.poll();
            if(poll.priority < p){
                queue.add(poll);
                continue;
            }
            count++;
            if(poll.location == location)
                return count;
            priority.remove(0);
        }

        return -1;
    }

    public static void main(String[] args) {
        solution2(new int[]{1, 1, 9, 1, 1, 1}, 0);
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


    class Literature{
        int location;
        int priority;

        public Literature(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
