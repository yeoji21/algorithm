package programmers;

import java.util.stream.IntStream;

public class 서울에서_김서방_찾기 {
    public String solution(String[] seoul) {
        int kim = IntStream.range(0, seoul.length)
                .filter(i -> seoul[i].equals("Kim"))
                .findAny()
                .getAsInt();
        return "김서방은 " + kim + "에 있다";
    }
}
