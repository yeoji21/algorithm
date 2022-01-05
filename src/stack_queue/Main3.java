package stack_queue;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[][] board = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        }

        int m = Integer.parseInt(in.readLine());
        Integer[] moves = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        new Main3().solution(board, n, moves, m);
    }

    public void solution(Integer[][] board, int n, Integer[] moves, int m) {
        List<Stack<Integer>> stackList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Stack<Integer> newStack = new Stack<>();
            for (int j = n-1; j > 0; j--) {
                Integer doll = board[j][i];
                if(doll != 0)
                    newStack.push(doll);
            }
            stackList.add(newStack);
        }


        Stack<Integer> result = new Stack<>();
        result.add(0);
        int totalCount = 0;
        for (Integer move : moves) {
            int index = move - 1;
            if(!stackList.get(index).isEmpty()) {
                Integer doll = stackList.get(index).pop();
                if (result.peek() == doll){
                    result.pop();
                    totalCount += 2;
                }
                else{
                    result.add(doll);
                }
            }
        }

        System.out.println(totalCount);
    }
}
