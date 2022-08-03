package programmers_level2;

import java.util.HashMap;
import java.util.Map;

public class _3차_압축 {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = initailizeDictionary();
        int idx = 27;



        return new int[]{};
    }

    private Map<String, Integer> initailizeDictionary() {
        Map<String, Integer> dictionary = new HashMap<>();

        int idx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), idx++);
        }
        return dictionary;
    }
}
