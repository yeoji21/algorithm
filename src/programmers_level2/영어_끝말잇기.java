package programmers_level2;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (!word.startsWith(String.valueOf(words[i - 1].charAt(words[i - 1].length() - 1))) || set.contains(word)) {
                int times = i / n + 1;
                int who = i % n + 1;
                return new int[]{who, times};
            }
            set.add(word);
        }


        return new int[]{0, 0};
    }
}
