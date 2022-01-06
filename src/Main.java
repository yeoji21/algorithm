import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        new Main().solution(str);
    }

    public void solution(String str) {
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