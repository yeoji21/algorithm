package programmers;

import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 3, 3, 0, 1, 1});
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(!stack.isEmpty()) {
                Integer peek = stack.peek();
                if(peek == arr[i]) continue;
            }
            stack.add(arr[i]);
        }

        return stack.stream().mapToInt(x -> x).toArray();
    }
}
