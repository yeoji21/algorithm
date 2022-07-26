package programmers_level2;

import java.util.Stack;

public class 주식가격 {
    // 스택에 값이 아닌 인덱스를 넣을 생각을 못함
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
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
