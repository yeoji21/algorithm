package programmers_level2;

import java.util.ArrayList;
import java.util.List;

public class 하노이의_탑 {

    private static List<int[]> sequence;
    public int[][] solution(int n) {
        sequence = new ArrayList<>();
        hanoi(n, 1, 3, 2);

        int[][] result = new int[sequence.size()][2];
        for (int i = 0; i < sequence.size(); i++) {
            int[] cmd = sequence.get(i);
            result[i][0] = cmd[0];
            result[i][1] = cmd[1];
        }

        return result;
    }

    private void hanoi(int n, int from, int to, int via) {
        int[] move = new int[]{from, to};

        if (n == 1) {
            sequence.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            sequence.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}
