package stack_queue;

import java.io.*;
import java.util.Stack;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] targetChars = in.readLine().toCharArray();
        new Main4().solution(targetChars);
    }

    public void solution(char[] targetChars) {
        Stack<Integer> nums = new Stack<>();

        for (char ch : targetChars) {
            if(Character.isDigit(ch))
                nums.push(Integer.parseInt(String.valueOf(ch)));
            else{
                Integer y = nums.pop();
                Integer x = nums.pop();

                if(ch == '+') nums.push(x + y);
                else if(ch == '-') nums.push(x - y);
                else if(ch == '*') nums.push(x * y);
                else nums.push(x / y);
            }
        }

        System.out.println(nums.pop());
    }
}
