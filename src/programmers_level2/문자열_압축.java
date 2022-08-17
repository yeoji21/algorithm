package programmers_level2;

import java.util.Stack;

public class 문자열_압축 {

    public static void main(String[] args) {
        solution("xababcdcdababcdcd");
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

    public static int solution2(String s) {
        int result = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String before = s.substring(0, i);
            String now = "";
            int count = 1;
            StringBuilder sb = new StringBuilder();

            for (int j = i; j <= s.length(); j += i) {
                if(j + i >= s.length())
                    now = s.substring(j, s.length());
                else now = s.substring(j, j + i);

                if(before.equals(now)){
                    count++;
                } else if (count == 1) {
                    sb.append(before);
                    before = now;
                } else {
                    sb.append(count).append(before);
                    before = now;
                    count = 1;
                }
            }
            if(before.length() != i) sb.append(before);

            result = Math.min(result, sb.length());
        }

        return result;
    }
}
