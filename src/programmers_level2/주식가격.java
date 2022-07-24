package programmers_level2;

import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 2, 3});
    }

    public static int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int pop = stack.pop();
                result[pop] = pop - stack.peek();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return result;
    }
}
