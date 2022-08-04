package programmers_level2;

import java.util.*;

public class _3차_압축 {

    static int idx = 1;
    public static int[] solution(String msg) {
        Map<String, Integer> dictionary = initailizeDictionary();
        List<Integer> result = new ArrayList<>();

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < msg.length(); i++) {
            queue.add(msg.charAt(i));
        }

        while (!queue.isEmpty()) {
            Character now = queue.poll();
            StringBuilder sb = new StringBuilder();
            sb.append(now);
            while(dictionary.containsKey(sb.toString())){
                if(dictionary.containsKey(sb.toString() + queue.peek())){
                    sb.append(queue.peek());
                    queue.poll();
                }
                else{
                    break;
                }
            }
            result.add(dictionary.get(sb.toString()));
            if (!queue.isEmpty()) {
                sb.append(queue.peek());
                dictionary.put(sb.toString(), idx++);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    private static Map<String, Integer> initailizeDictionary() {
        Map<String, Integer> dictionary = new HashMap<>();

        idx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), idx++);
        }
        return dictionary;
    }
}
