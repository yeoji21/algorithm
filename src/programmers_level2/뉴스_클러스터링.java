package programmers_level2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class 뉴스_클러스터링 {
    private static final Pattern PATTERN = Pattern.compile("[^A-Z]");
    public static int solution2(String str1, String str2) {
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


    public static int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> words1 = new HashMap<>();
        Map<String, Integer> words2 = new HashMap<>();

        int total = 0;
        total = splitSentenceToWord(str1, words1, total);
        total = splitSentenceToWord(str2, words2, total);

        if(total == 0) return calculateResult(1);

        double match = 0;
        for (String key : words1.keySet()) {
            if (words2.containsKey(key)) {
                while(words1.get(key) > 0 && words2.get(key) > 0) {
                    match++;
                    words1.put(key, words1.get(key) - 1);
                    words2.put(key, words2.get(key) - 1);
                }
            }
        }

        return calculateResult((double) (match / (total - match)));
    }

    private static int splitSentenceToWord(String str1, Map<String, Integer> words1, int total) {
        for (int i = 0; i < str1.length() - 1 ; i++) {
            String substring = str1.substring(i, i + 2);
            if(!isOnlyAlphabet(substring)) continue;
            words1.put(substring, words1.getOrDefault(substring, 0) + 1);
            total++;
        }
        return total;
    }

    private static boolean isOnlyAlphabet(String target) {
        return target.chars().allMatch(Character::isAlphabetic);
    }

    private static int calculateResult(double result) {
        return (int) (result * 65536);
    }
}
