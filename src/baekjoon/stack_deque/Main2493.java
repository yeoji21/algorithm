package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {
    static int N;
    static int[] heights;
    static Stack<Integer> stack;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new int[N + 1];
        List<Integer> result = new ArrayList<>();
        stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        stack.push(0);

        for (int i = 1; i <= N; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] < heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) result.add(stack.peek());
            else result.add(0);

            stack.push(i);
        }

        result.forEach(x -> System.out.print(x + " "));
    }
}
