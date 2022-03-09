package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length - 1; i++) {
            if(input[i] == '(' && input[i+1] == ')'){
                result += stack.size();
                i++;
            }
            else{
                if(input[i] == '(') {
                    stack.push('(');
                    result++;
                }
                else if (input[i] == ')') stack.pop();
            }
        }

        System.out.println(result);
    }
}