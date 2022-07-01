package programmers_level2;

import java.util.Stack;

public class 괄호_변환 {
    public String solution(String p) {
        if(p.equals("")) return "";
        if(isCorrectString(p)) return p;

        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] split = split(p);

            if (!isCorrectString(split[0])) {
                StringBuilder step4 = new StringBuilder("(");
                step4.append(solution(split[1]));
                step4.append(")");
                step4.append(getOppositeString(split[0]));

                sb.append(step4);
                return sb.toString();
            }

            sb.append(split[0]);
            p = split[1];

            if(split[1].equals("")) break;
        }

        return sb.toString();
    }

    private static String getOppositeString(String split) {
        String reverse = "";
        if(!split.equals("")) {
            String substring = split.substring(1, split.length() - 1);
            char[] chars = substring.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == '(') chars[i] = ')';
                else chars[i] = '(';
            }
            reverse = String.valueOf(chars);
        }
        return reverse;
    }

    private String[] split(String target) {
        int open = 0;
        int close = 0;
        int idx = 0;

        for (idx = 0; idx < target.length(); idx++) {
            if(target.charAt(idx) == '(') open++;
            else if(target.charAt(idx) == ')') close++;

            if(open == close) break;
        }

        return new String[]{target.substring(0, idx + 1), target.substring(idx + 1)};
    }

    public boolean isCorrectString(String target) {
        Stack<Character> stack = new Stack<>();

        for (char ch : target.toCharArray()) {
            if(ch == '(')
                stack.push(ch);
            else if(ch == ')' && !stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else return false;
        }

        return stack.size() == 0;
    }
}
