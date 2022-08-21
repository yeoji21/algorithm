package programmers_level2;

import java.util.*;

public class 기능개발 {
    public int[] solution2(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            int count = 0;
            while (!queue.isEmpty() && progresses[queue.peek()] >= 100) {
                queue.poll();
                count++;
            }
            if(count > 0 ) result.add(count);
        }

        return result.stream()
                .mapToInt(x -> x)
                .toArray();
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> stack = new ArrayList<>(progresses.length);
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(progresses).forEach(queue::add);

        int size = progresses.length;

        int count = 1;
        while (!queue.isEmpty()) {
            int release = 0;
            while (!queue.isEmpty() && queue.peek() + (count * speeds[size - queue.size()]) >= 100) {
                queue.poll();
                release++;
            }
            if(release > 0) stack.add(release);
            count++;
        }

        return stack.stream().mapToInt(x -> x).toArray();
    }
}
