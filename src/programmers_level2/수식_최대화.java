package programmers_level2;

import java.util.*;
import java.util.stream.Collectors;

public class 수식_최대화 {
    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }


    public static long solution(String expression) {
        List<String> numbers = Arrays.stream(expression.split("\\D")).collect(Collectors.toList());
//        List<String> operations = Arrays.stream(expression.replaceAll("\\d", "").split("")).collect(Collectors.toList());
//        operations.forEach(System.out::println);

        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(!Character.isDigit(ch)) {
                List<Integer> list = map.get(i);
                if(list == null) list = new ArrayList<>();
                list.add(i);
                map.put(ch, list);
            }
        }

        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : ");
            entry.getValue().forEach(System.out::println);
        }


        return 0;
    }
}
