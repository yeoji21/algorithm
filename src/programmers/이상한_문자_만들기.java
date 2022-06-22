package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 이상한_문자_만들기 {
    public static void main(String[] args) {
        String solution = solution("wo rl d");
        System.out.println(solution);
    }

    public static String solution(String s) {
        return Arrays.stream(s.split("\\b+"))
                .map(word -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < word.length(); i++) {
                        sb.append(i % 2 == 0 ? String.valueOf(word.charAt(i)).toUpperCase() : String.valueOf(word.charAt(i)).toLowerCase());
                    }
                    return sb.toString();
                })
                .collect(Collectors.joining());
    }
}
