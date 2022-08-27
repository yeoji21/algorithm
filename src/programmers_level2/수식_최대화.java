package programmers_level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 수식_최대화 {
    private char[][] priorities = new char[][]{
            {'*', '+', '-'},
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '*', '+'},
            {'-', '+', '*'},
            {'*', '-', '+'}
    };

    public long solution(String expression) {
        List<Long> numbers = new LinkedList<>();
        List<Character> operators = new LinkedList<>();

        for (String s : expression.split("\\D"))
            numbers.add(Long.parseLong(s));

        for (String s : expression.split("\\d+")) {
            if(s.isBlank()) continue;
            operators.add(s.charAt(0));
        }

        long maxValue = 0;
        for (int i = 0; i < priorities.length; i++) {
            long value = calculateExpression(priorities[i], new ArrayList<>(numbers), new ArrayList<>(operators));
            maxValue = Math.max(Math.abs(value), maxValue);
        }

        return maxValue;
    }

    private static long calculateExpression(char[] priority, List<Long> numbers, List<Character> operators) {
        long sum = 0;

        for (char op : priority) {
            while (operators.contains(op)) {
                int index = operators.indexOf(op);
                long value = calc(op, numbers.get(index), numbers.get(index + 1));
                sum = value;
                numbers.set(index, value);
                numbers.remove(index + 1);
                operators.remove(index);
            }
        }

        return sum;
    }

    private static long calc(char op, long x, long y) {
        if(op == '+') return x + y;
        else if (op == '-') return x - y;
        else return x * y;
    }
}
