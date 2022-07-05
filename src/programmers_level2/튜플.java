package programmers_level2;

import java.util.*;
import java.util.stream.Collectors;

public class 튜플 {
    public static void main(String[] args) {
        solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }


    public static int[] solution(String s) {
        s = removeParenthes(s);

        List<String> sortedItem = Arrays.stream(splitWithComma(s))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        Set<Integer> set = new LinkedHashSet<>();

        for (String item : sortedItem) {
            item = removeParenthes(item);
            Arrays.stream(item.split(","))
                    .mapToInt(Integer::parseInt)
                    .forEach(set::add);
        }

        return set.stream().mapToInt(x -> x).toArray();
    }

    private static String[] splitWithComma(String target) {
        return target.split(",+(?=\\{)");
    }

    private static String removeParenthes(String target) {
        return target.substring(1, target.length() - 1);
    }
}
