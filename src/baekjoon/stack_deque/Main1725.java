package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1725 {
    static int N, result;
    static int[] heights;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        heights = new int[N + 2];
        stack = new Stack<>();

        for (int i = 1; i <= N; i++)
            heights[i] = Integer.parseInt(br.readLine());

        stack.push(0);

        for (int i = 1; i <= N+1; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int idx = stack.pop();
                result = Math.max(result, heights[idx] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        System.out.println(result);
    }
}

