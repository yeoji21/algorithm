package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1725 {
    private static int max = Integer.MIN_VALUE;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = getIntValue(br);

        Stack<Hist> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = getIntValue(br);

            while (!stack.isEmpty() && stack.peek().height > num) {
                int height = stack.pop().height;
                int width = i;
                if(!stack.isEmpty()) width -= stack.peek().idx + 1;
                max = Math.max(max, height * width);
            }
            stack.push(new Hist(i, num));
        }

        while (!stack.isEmpty()) {
            int height = stack.pop().height;
            int width = N;
            if(!stack.isEmpty()) width -= stack.peek().idx + 1;
            max = Math.max(max, height * width);
        }

        System.out.println(max);
    }

    private static int getIntValue(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static class Hist{
        private int idx, height;

        public Hist(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}