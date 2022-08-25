import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        int solution = solution("FRANCE", "french");
//        int solution = solution("handshake", "shake hands");
//        int solution = solution("aa1+aa2", "AAAA12");
//        int solution = solution("E=M*C^2", "e=m*c^2");

        System.out.println(solution);
    }

    private static final Pattern PATTERN = Pattern.compile("[^A-Z]");
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        Map<String, Integer> map1 = toMap(str1);
        int map1Size = map1.values().stream().mapToInt(x -> x).sum();

        Map<String, Integer> map2 = toMap(str2);
        int map2Size = map2.values().stream().mapToInt(x -> x).sum();

        int commonElements = 0;
        for (String key : map1.keySet()) {
            while (map2.containsKey(key) && map1.get(key) > 0 && map2.get(key) > 0){
                commonElements++;
                map1.put(key, map1.get(key) - 1);
                map2.put(key, map2.get(key) - 1);
            }
        }

        if(map1Size - commonElements == 0 && map2Size - commonElements == 0) return 65536;

        double result = (double) commonElements / (double) (map1Size - commonElements + map2Size);
        return (int)(result * 65536);
    }

    private static Map<String, Integer> toMap(String target) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < target.length() - 1; i++) {
            String substring = target.substring(i, i + 2);
            if(PATTERN.matcher(substring).find()) continue;
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }

        return map;
    }
}
