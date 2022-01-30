package inflean.stack_queue;

import java.io.*;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] targetChars = in.readLine().toCharArray();
        new Main2().solution(targetChars);
    }

    public void solution(char[] targetChars) {
        Stack<Character> stack = new Stack<>();

        for (char ch : targetChars) {
            if(ch == ')')
                while(!stack.isEmpty() && stack.pop() != '(');
            else
                stack.push(ch);
        }

        stack.forEach(System.out::print);
    }
}
