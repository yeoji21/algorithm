package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2812 {
    private static int N, K;
    private static String num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = br.readLine();

        makeItBig();
    }

    private static void makeItBig() {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < num.length(); i++) {
            int value = num.charAt(i) - '0';
            while(count < K && !stack.isEmpty() && stack.peek() < value){
                stack.pop();
                count++;
            }
            stack.push(value);
        }

        String result = IntStream.range(0, N - K)
                .mapToObj(i -> String.valueOf(stack.get(i)))
                .collect(Collectors.joining());
        System.out.println(result);
    }

}