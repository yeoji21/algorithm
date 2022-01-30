package inflean.stack_queue;

import java.io.*;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] targetChars = in.readLine().toCharArray();
        new Main1().solution(targetChars);
    }

    public void solution(char[] targetChars) {
        Stack<Character> stack = new Stack<>();

        boolean flag = true;
        for (char aChar : targetChars) {
            if(aChar == '(')
                stack.push(aChar);
            else{
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                else{
                    flag = false;
                    break;
                }
            }
        }
        if(stack.size() == 0 && flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}