package programmers_level2;

import java.util.Stack;

public class 괄호_회전하기 {
    public int solution(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if(validate(s)) {
                System.out.println(s);
                result++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(1, s.length()));
            sb.append(s.charAt(0));
            s = sb.toString();
        }

        return result;
    }

    private boolean validate(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            }
            else{
                if(stack.size() == 0) return false;

                Character top = stack.peek();
                if(ch == ']' && top == '[') stack.pop();
                else if(ch == ')' && top == '(') stack.pop();
                else if(ch == '}' && top == '{') stack.pop();
                else return false;
            }
        }

        return stack.size() == 0;
    }


}
