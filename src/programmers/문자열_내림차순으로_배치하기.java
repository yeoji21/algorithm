package programmers;

import java.nio.CharBuffer;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 문자열_내림차순으로_배치하기 {


    public String solution(String s) {
        Stream<Character> characterStream = CharBuffer.wrap(s.toCharArray()).chars().mapToObj(c -> (char) c);
        return characterStream.sorted(Comparator.comparing((Character c) -> c).reversed())
                .map(String::valueOf).collect(Collectors.joining());
    }
}
