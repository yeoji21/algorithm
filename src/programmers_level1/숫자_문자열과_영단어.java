package programmers_level1;

import java.util.HashMap;
import java.util.Map;

public class 숫자_문자열과_영단어 {
    public int solution(String s) {
        Map<String, Integer> map = initializeMap();

        for (Map.Entry<String, Integer> es : map.entrySet()) {
            s = s.replaceAll(es.getKey(), es.getValue().toString());
        }

        return Integer.parseInt(s);
    }

    private Map<String, Integer> initializeMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        return map;
    }
}
