package programmers_level2;

import java.util.*;

public class _3차_압축 {
    public int[] solution(String msg) {
        int idx = 1;
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) dictionary.put(String.valueOf(c), idx++);
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < msg.length(); i++) {
            queue.add(msg.charAt(i));
        }

        while (!queue.isEmpty()) {
            Character now = queue.poll();
            StringBuilder sb = new StringBuilder();
            sb.append(now);
            while(dictionary.containsKey(sb.toString()) && dictionary.containsKey(sb.toString() + queue.peek())){
                sb.append(queue.peek());
                queue.poll();
            }
            result.add(dictionary.get(sb.toString()));
            if (!queue.isEmpty()) {
                sb.append(queue.peek());
                dictionary.put(sb.toString(), idx++);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

}
