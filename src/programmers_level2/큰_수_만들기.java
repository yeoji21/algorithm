package programmers_level2;

import java.util.Stack;
import java.util.stream.Collectors;

public class 큰_수_만들기 {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : number.toCharArray()) {
            int num = ch - '0';
            while (!stack.isEmpty() && num > stack.peek() && k > 0) {
                k--;
                stack.pop();
            }
            stack.push(num);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
