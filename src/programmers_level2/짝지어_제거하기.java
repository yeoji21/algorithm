package programmers_level2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if(stack.peek().equals(s.charAt(i))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
