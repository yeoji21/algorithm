package programmers_level2;

import java.util.*;
import java.util.stream.Collectors;

public class 수식_최대화 {
    static char[][] priorities = new char[][]{
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'*', '-', '+'},
            {'*', '+', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'}
    };

    public long solution(String expression) {
        List<Long> numbers = Arrays.stream(expression.split("\\D")).map(Long::parseLong).collect(Collectors.toList());
        Map<Character, List<Integer>> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(!Character.isDigit(ch)) {
                List<Integer> list = map.get(ch);
                if(list == null) list = new ArrayList<>();
                list.add(count++);
                map.put(ch, list);
            }
        }

        long maxPrize = 0;
        for (int i = 0; i < priorities.length; i++) {
            long prize = getMaxPrize(new ArrayList<>(numbers), copyMap(map), priorities[i]);
            maxPrize = Math.max(maxPrize, prize);
        }

        return maxPrize;
    }

    private static long getMaxPrize(List<Long> numbers, Map<Character, List<Integer>> operations, char[] priority) {
        for (int i = 0; i < priority.length; i++) {
            List<Integer> idx = operations.get(priority[i]);
            if(idx == null) continue;
            for (int j = 0; j < idx.size(); j++) {
                Integer index = idx.get(j);
                if(numbers.size() == 1) return numbers.get(0) < 0 ? numbers.get(0) * -1 : numbers.get(0);

                long result = calcalate(numbers.get(index), priority[i], numbers.get(index+1));
                numbers.remove(index+1);
                numbers.set(index, result);

                for (Map.Entry<Character, List<Integer>> entry : operations.entrySet()) {
                    List<Integer> list = operations.get(entry.getKey());
                    for (int n = 0; n < list.size(); n++) {
                        if(list.get(n) > index)
                            list.set(n, list.get(n) - 1);
                    }
                }
            }
        }
        return numbers.get(0) < 0 ? numbers.get(0) * -1 : numbers.get(0);
    }

    private Map<Character, List<Integer>> copyMap(Map<Character, List<Integer>> map) {
        Map<Character, List<Integer>> copy = new HashMap<>();
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }

    private static long calcalate(long x, char op, long y) {
        if (op == '*') return x * y;
        else if (op == '+') return x + y;
        else return x - y;
    }
}
