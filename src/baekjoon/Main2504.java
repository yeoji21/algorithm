package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        char[] arr = br.readLine().toCharArray();
        int answer = 0;
        int temp = 1;

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == '(' || ch == '[') {
                stack.add(ch);
                temp *= ch == '(' ? 2 : 3;
            }else{
                if (ch == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        answer = 0;
                        break;
                    }
                    stack.pop();
                    if(arr[i - 1] == '(') answer += temp;
                    temp /= 2;
                }else{
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = 0;
                        break;
                    }
                    stack.pop();
                    if(arr[i -1] == '[') answer += temp;
                    temp /= 3;
                }
            }
        }
        if(!stack.isEmpty()) answer = 0;
        System.out.println(answer);
    }
}
