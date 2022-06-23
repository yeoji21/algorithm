package programmers_level1;

import java.util.Arrays;
import java.util.Stack;

public class 크레인_인형뽑기_게임 {
    static int result = 0;

    public int solution(int[][] board, int[] moves) {
        DollBasket basket = new DollBasket();

        Arrays.stream(moves).forEach(column -> {
            int pickedDoll = pickUpDoll(board, column);
            if(pickedDoll != 0) {
                result += basket.addDoll(pickedDoll);
            }
        });

        return result;
    }

    private int pickUpDoll(int[][] board, int column) {
        column -= 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 0) {
                int pick = board[i][column];
                board[i][column] = 0;
                return pick;
            }
        }
        return 0;
    }

    static class DollBasket{
        private final Stack<Integer> selected = new Stack<>();

        public int addDoll(int doll) {
            if(!selected.isEmpty()) {
                Integer dollOnTop = selected.peek();
                if (dollOnTop == doll) {
                    selected.pop();
                    return 2;
                }
            }
            selected.push(doll);
            return 0;
        }
    }
}
