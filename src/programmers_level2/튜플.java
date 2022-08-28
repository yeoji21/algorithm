package programmers_level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 튜플 {
    public static int[] solution(String s) {
        s = removeParentheses(s);
        s = s.replaceAll("(},)", "}e");
        String[] tuples = s.split("e");
        int[] answer = new int[tuples.length];
        Arrays.sort(tuples, Comparator.comparing(String::length));
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < tuples.length; i++) {
            String tuple = tuples[i];
            tuple = removeParentheses(tuple);
            for (String number : tuple.split(",")) {
                int value = Integer.parseInt(number);
                if(set.contains(value)) continue;
                set.add(value);
                answer[i] = value;
                break;
            }
        }

        return answer;
    }

    private static String removeParentheses(String s) {
        return s.substring(1, s.length() - 1);
    }
}
