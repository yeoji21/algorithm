package programmers_level2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 영어_끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] result = new int[2];
        Set<String> check = new HashSet<>();
        Stack<String> stack = new Stack<>();


        for (int round = 0; round < words.length / n + 1; round++) {
            for (int i = 0; i < n && round * n + i < words.length; i++) {
                String word = words[round * n + i];
                if ((!stack.isEmpty() && stack.peek().charAt(stack.peek().length() - 1) != word.charAt(0))
                        || check.contains(word)) {
                    result[0] = i + 1;
                    result[1] = round + 1;
                    return result;
                }
                stack.add(word);
                check.add(word);
            }
        }

        return new int[]{0, 0};
    }
}
