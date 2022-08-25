package programmers_level2;

import java.util.Stack;

public class 괄호_변환 {
    public String solution(String p) {
        if(isCorrectString(p) || p.isBlank()) return p;

        String[] split = split(p);
        if(isCorrectString(split[0]))
            return split[0] + solution(split[1]);

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(split[1]));
        sb.append(")");

        for (int i = 1; i < split[0].length() - 1; i++) {
            char ch = split[0].charAt(i);
            if(ch == '(') sb.append(")");
            else sb.append("(");
        }

        return sb.toString();
    }

    private String[] split(String target) {
        int open = 0;
        int close = 0;

        int i;
        for (i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);

            if(ch == '(') open++;
            else close++;
            if(open > 0 && open == close) break;
        }

        return new String[]{target.substring(0, i + 1), target.substring(i + 1)};
    }

    private boolean isCorrectString(String target) {
        Stack<Character> stack = new Stack<>();

        for (char ch : target.toCharArray()) {
            if(ch == '(') stack.add(ch);
            else{
                if(stack.isEmpty() || stack.peek() == ')')
                    return false;
                stack.pop();
            }
        }

        return stack.size() == 0;
    }
}
