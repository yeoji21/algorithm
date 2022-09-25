package programmers_level2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
            else stack.push(ch);
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
