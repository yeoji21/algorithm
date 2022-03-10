package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2812 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        Integer[] target = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toArray(Integer[]::new);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < target.length; i++) {
            while (count < K && !stack.isEmpty() && stack.peek() < target[i]) {
                stack.pop();
                count++;
            }
            stack.push(target[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-K; i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb.toString());
    }
}
