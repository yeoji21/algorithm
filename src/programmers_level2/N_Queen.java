package programmers_level2;

public class N_Queen {
    // https://excited-hyun.tistory.com/189
    // https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-N-Queen-Java

    public static void main(String[] args) {
        int solution = solution(4);
        System.out.println(solution);
    }

    private static int result = 0;
    public static int solution(int n) {
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            col[0] = i;
            backtracking(col, n, 1);
        }

        return result;
    }

    private static void backtracking(int[] col, int max, int row) {
        if (row == max) {
            result++;
            return;
        }

        for (int i = 0; i < max; i++) {
            col[row] = i;
            if (isPossible(col, row)) {
                backtracking(col, max, row + 1);
            }
            else{
                col[row] = 0;
            }
        }

    }

    private static boolean isPossible(int[] col, int row) {
        for (int i = 0; i < row; i++) {
            if(col[i] == col[row]) return false;
            if(Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }
        return true;
    }
}
