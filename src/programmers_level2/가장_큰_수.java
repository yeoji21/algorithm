package programmers_level2;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> Integer.compare(Integer.parseInt(s2 + s1), Integer.parseInt(s1 + s2)))
                .collect(joining());
        return answer.startsWith("0") ? "0" : answer;
    }
}
