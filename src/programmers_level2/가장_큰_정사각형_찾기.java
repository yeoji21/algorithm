package programmers_level2;

public class 가장_큰_정사각형_찾기 {
    static int[][] dp;

    public int solution(int [][]board) {
        int result = 0;

        int n = board.length;
        int m = board[0].length;

        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = board[i][0];
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = board[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(board[i][j] != 1) continue;
                dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }

        return result * result;
    }
}
