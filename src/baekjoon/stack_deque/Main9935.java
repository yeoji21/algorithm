package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] total = br.readLine().toCharArray();
        String boom = br.readLine();
        int length = boom.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < total.length; i++) {
            stack.push(total[i]);
            if (stack.peek() == boom.charAt(length - 1) && stack.size() >= length) {
                sb = new StringBuilder();
                for (int j = stack.size() - length; j < stack.size(); j++) {
                    sb.append(stack.get(j));
                }
                if(sb.toString().equals(boom)){
                    for (int k = 0; k < length; k++) stack.pop();
                }
            }
        }

        sb = new StringBuilder();
        stack.forEach(sb::append);
        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb);
    }
}
