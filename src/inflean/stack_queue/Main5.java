package inflean.stack_queue;

import java.io.*;
import java.util.Stack;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] targetChars = in.readLine().toCharArray();
        new Main5().solution(targetChars);
    }

    public void solution(char[] targetChars) {
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < targetChars.length; i++) {
            // laser
            if(targetChars[i] == '(' && targetChars[i + 1] == ')'){
                i++;
                result += stack.size();
            }
            else if (targetChars[i] == ')') stack.pop();
            else {
                stack.push(targetChars[i]);
                result++;
            }
        }
        System.out.println(result);
    }

    public void solution2(String str) {
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack.push('(');
            else{
                stack.pop();
                if(str.charAt(i-1) == '(') result += stack.size();
                else result++;
            }
        }
        System.out.println(result);
    }
}