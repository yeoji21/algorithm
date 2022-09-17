package programmers_level2;

import java.util.Stack;

public class 큰_수_만들기 {
    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int size = number.length() - k;

        for (char ch : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < ch && k - 1 >= 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        for (int i = 0; i < size; i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}
