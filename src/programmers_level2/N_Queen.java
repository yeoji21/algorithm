package programmers_level2;

public class N_Queen {
    // https://excited-hyun.tistory.com/189
    // https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-N-Queen-Java
    // https://yeongjin13.tistory.com/62
    private int answer = 0;
    public int solution(int n) {
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            col[0] = i;
            backtracking(col, 1);
        }
        return answer;
    }

    private void backtracking(int[] col, int row) {
        if (row == col.length) {
            answer++;
            return;
        }

        for (int i = 0; i < col.length; i++) {
            col[row] = i;
            if(check(col, row)){
                backtracking(col, row + 1);
            }else{
                col[row] = 0;
            }
        }
    }

    private boolean check(int[] col, int row) {
        for (int i = 0; i < row; i++) {
            if(col[i] == col[row]) return false;
            if(Math.abs(col[i] - col[row]) == Math.abs(i - row)) return false;
        }
        return true;
    }
}
