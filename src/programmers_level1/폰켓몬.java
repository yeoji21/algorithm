package programmers_level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(poketmon -> map.put(poketmon, map.getOrDefault(poketmon, 0) + 1));
        return Math.min(map.keySet().size(), nums.length / 2);
    }
}
