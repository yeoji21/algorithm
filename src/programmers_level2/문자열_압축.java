package programmers_level2;

import java.util.Stack;

public class 문자열_압축 {

    public static void main(String[] args) {
        solution("xababcdcdababcdcd");

        int length = (int) Math.log10(1) + 1;
        System.out.println(length);
    }

    public static int solution(String s) {
        if(s.length() == 1) return 1;

        int minLength = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length() / 2; i++) {
            String[] split = s.split("(?<=\\G.{" + i + "})");
            int result = encrypt(split);
            minLength = Math.min(result, minLength);
        }

        return minLength;
    }

    private static int encrypt(String[] split) {
        Stack<String> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < split.length; i++) {
            if(stack.isEmpty()) stack.push(split[i]);
            else {
                if (stack.peek().equals(split[i])) stack.push(split[i]);
                else {
                    if(stack.size() == 1) result += stack.peek().length();
                    else result += stack.peek().length() + String.valueOf(stack.size()).length();

                    stack.clear();
                    stack.push(split[i]);
                }
            }
        }

        if(!stack.isEmpty()) {
            if(stack.size() == 1) result += stack.peek().length();
            else result += stack.peek().length() + String.valueOf(stack.size()).length();
        }

        return result;
    }
}
