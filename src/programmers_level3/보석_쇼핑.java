package programmers_level3;

import java.util.*;

public class 보석_쇼핑 {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        set.addAll(Arrays.asList(gems));
        int[] answer = new int[2];
        int distance = Integer.MAX_VALUE;
        int startIdx = 0;

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            q.add(gems[i]);

            while (map.get(q.peek()) > 1) {
                map.put(q.peek(), map.get(q.poll()) - 1);
                startIdx++;
            }
            if (map.size() == set.size() && distance > i - startIdx) {
                distance = i - startIdx;
                answer[0] = startIdx + 1;
                answer[1] = i + 1;
            }
        }

        return answer;
    }
}
