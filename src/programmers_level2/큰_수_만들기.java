package programmers_level2;

import java.util.Stack;

public class 큰_수_만들기 {
    public static void main(String[] args) {
        String solution = solution("1924", 3);
//        String solution = solution("1231234", 3);
//        String solution = solution("4177252841", 4);
//        String solution = solution("4177252841", 7);
        System.out.println(solution);
    }

    public static String solution(String number, int k) {
        int pick = number.length() - k;

        int max = -1;
        int maxIdx = -1;
        StringBuilder selected = new StringBuilder();

        for (int i = number.length() - pick; i >= 0; i--) {
            if(number.charAt(i) - '0' >= max) {
                max = number.charAt(i) - '0';
                maxIdx = i;
            }
        }
        selected.append(max);

        for (int i = 1; i < pick; i++) {
            max = -1;
            for (int j = maxIdx + 1; j <= number.length() - (pick - i); j++) {
                if (number.charAt(j) - '0' > max) {
                    max = number.charAt(j) - '0';
                    maxIdx = j;
                }
            }
            selected.append(max);
        }

        return selected.toString();
    }

    public static String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return new String(result);
    }
}
