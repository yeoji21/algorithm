package programmers_level2;

public class 가장_큰_정사각형_찾기 {
    private int[] dx = {-1, -1, 0};
    private int[] dy = {-1, 0, -1};
    public int solution(int [][]board) {
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 0) continue;
                int min = Integer.MAX_VALUE;
                for (int d = 0; d < 3; d++) {
                    min = Math.min(min, board[i + dx[d]][j + dy[d]]);
                }
                board[i][j] = min + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max * max;
    }
}
