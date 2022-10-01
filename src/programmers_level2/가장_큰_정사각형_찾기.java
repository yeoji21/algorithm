package programmers_level2;

public class 가장_큰_정사각형_찾기 {
    public int solution(int [][]board) {
        int answer = 0;
        int[][] dp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            dp[i][0] = board[i][0];
            answer = Math.max(answer, dp[i][0]);
        }
        for (int i = 0; i < board[0].length; i++) {
            dp[0][i] = board[0][i];
            answer = Math.max(answer, dp[0][i]);
        }

        int[] dx = new int[]{-1, -1, 0};
        int[] dy = new int[]{-1, 0, -1};

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(board[i][j] != 1) continue;

                int min = 1000;
                for (int d = 0; d < 3; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    min = Math.min(dp[nx][ny], min);
                }
                dp[i][j] = min + 1;
                answer = Math.max(min + 1, answer);
            }
        }

        return answer * answer;
    }
}
