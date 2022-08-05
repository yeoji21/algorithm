package programmers_level2;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c == '('){
                stack.push(c);
            } else if (c == ')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.size() == 0;
    }
}
