package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while(--T >= 0){
            String r = validation(br.readLine().toCharArray());
            result.append(r + "\n");
        }
        System.out.println(result.toString());
    }

    private static String validation(char[] data) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            char c = data[i];
            if(c == '(') stack.push(c);
            else if(c == ')') {
                if(stack.size() > 0) stack.pop();
                else return "NO";
            }
        }
        if(stack.size() == 0) return "YES";
        return "NO";
    }
}
