package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(participant).forEach(athlete -> map.put(athlete, map.getOrDefault(athlete, 0) + 1));
        Arrays.stream(completion).forEach(athlete -> map.put(athlete, map.get(athlete) - 1));

        return map.entrySet().stream().filter(es -> es.getValue() != 0).map(Map.Entry::getKey).findAny().get();
    }
}
