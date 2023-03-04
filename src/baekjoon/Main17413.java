package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main17413 {
    /*
    알파벳 소문자, 숫자, 공백, <>
    <태그>안에 문자는 안뒤집음
    단어는 알파벳과 숫자로만 이루어짐
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        solution(s);
    }

    private void solution(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                popStack(stack, answer);
                answer.append(ch);
            } else if (ch == '<') {
                popStack(stack, answer);
                answer.append(ch);
                int idx = i;
                while (s.charAt(idx) != '>') {
                    idx++;
                    answer.append(s.charAt(idx));
                }
                i = idx;
            }else{
                stack.add(ch);
            }
            i++;
        }
        popStack(stack, answer);
        System.out.println(answer.toString());
    }

    private void popStack(Stack<Character> stack, StringBuilder answer) {
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main17413().solv();
    }
}
