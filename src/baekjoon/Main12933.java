package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main12933 {
    /*
    quack
    소리를 듣고 오리가 최소 몇 마리인지
    quqacukqauackck
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        solution(target);
    }

    private void solution(String target) {
        Queue<Stack<Character>> q = new LinkedList<>();
        int answer = 0;
        for (char ch : target.toCharArray()) {
            if(ch == 'q') {
                Stack<Character> stack = new Stack<>();
                stack.add('q');
                q.add(stack);
                answer = Math.max(answer, q.size());
            }else{
                boolean insert = false;
                for (Stack<Character> stack : q) {
                    if(insertable(stack.peek(), ch)){
                        stack.add(ch);
                        insert = true;
                        if(ch == 'k') q.remove(stack);
                        break;
                    }
                }
                if(!insert){
                    answer = -1;
                    break;
                }
            }
        }
        for (Stack<Character> stack : q){
            if (stack.size() != 0) {
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
    }

    private boolean insertable(char before, char ch) {
        return (ch == 'u' && before == 'q') || (ch == 'a' && before == 'u') ||
                (ch == 'c' && before == 'a') || (ch == 'k' && before == 'c');
    }

    public static void main(String[] args) throws Exception {
        new Main12933().solv();
    }
}
