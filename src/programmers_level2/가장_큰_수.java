package programmers_level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining());
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}
