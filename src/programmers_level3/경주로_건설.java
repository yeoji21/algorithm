package programmers_level3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 경주로_건설 {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};
    private int[][][] dp;
    private int answer = Integer.MAX_VALUE;
    private int N;

    public int solution(int[][] board) {
        N = board.length;
        dp = new int[N][N][4];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][0][3] = 0;

        BFS(board);
        return answer;
    }

    void BFS(int[][] board){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int prev = now[2];

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                if(board[nx][ny] == 1) continue;

                int cost = dp[x][y][prev];
                if((x == 0 && y == 0) || (prev % 2 == d % 2)) cost += 100;
                else cost += 600;

                if(dp[nx][ny][d] < cost) continue;

                if(nx == N - 1 && ny == N - 1) answer = Math.min(answer, cost);
                dp[nx][ny][d] = cost;
                q.add(new int[]{nx, ny, d});
            }
        }
    }
}
