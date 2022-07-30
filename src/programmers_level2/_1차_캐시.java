package programmers_level2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class _1차_캐시 {
    public static void main(String[] args) {
        solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
    }

    public static int solution(int cacheSize, String[] cities) {
        Set<String> cache = new LinkedHashSet<>(cacheSize * 2);
        List<String> list = new ArrayList<>();
        String first = "";

        int result = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase();

            // hit
            if (!cache.isEmpty() && cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                result++;
                continue;
            }

            //miss
            if (cache.size() == cacheSize) {
                // 맨 앞 원소 제거하는게 오래 걸려서 그냥 LinkedList 쓰는게 나음
                String remove = cache.toArray(String[]::new)[0];
                cache.remove(remove);
            }

            cache.add(city);
            result += 5;
        }

        return result;
    }
}
