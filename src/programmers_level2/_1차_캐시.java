package programmers_level2;

import java.util.LinkedHashSet;
import java.util.Set;

public class _1차_캐시 {
    public int solution(int cacheSize, String[] cities) {
        Set<String> cache = new LinkedHashSet<>(cacheSize * 2);
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
                String remove = cache.toArray(String[]::new)[0];
                cache.remove(remove);
            }

            cache.add(city);
            result += 5;
        }

        return result;
    }
}
