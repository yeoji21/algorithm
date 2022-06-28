package programmers_level2;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        Arrays.stream(solution).forEach(System.out::println);
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
