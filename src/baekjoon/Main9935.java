package baekjoon;

import java.io.*;
import java.util.*;

public class Main9935 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();
        String boom = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < target.length(); i++){
            stack.add(target.charAt(i));
            if(stack.peek() == boom.charAt(boom.length() - 1) && stack.size() >= boom.length()){
                StringBuilder sb = new StringBuilder();
                for(int j = stack.size() - boom.length(); j < stack.size(); j++){
                    sb.append(stack.get(j));
                }

                if(sb.toString().equals(boom)){
                    for(int j = 0; j < boom.length(); j++) stack.pop();
                }
            }
        }

        String answer;
        if(stack.size() == 0) answer = "FRULA";
        else {
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) sb.append(stack.pop());
            sb.reverse();
            answer = sb.toString();
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main9935().solv();
    }
}
