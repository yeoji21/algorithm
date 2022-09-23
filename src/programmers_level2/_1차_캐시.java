package programmers_level2;

import java.util.*;

public class _1차_캐시 {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> queue = new LinkedList<>();
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        for (String city : cities) {
            String c = city.toUpperCase();
            if(queue.contains(c)) {
                answer += 1;
                queue.remove(c);
                queue.add(c);
            }
            else{
                if(queue.size() < cacheSize)
                    queue.add(c);
                else{
                    queue.poll();
                    queue.add(c);
                }
                answer += 5;
            }
        }

        return answer;
    }
}
