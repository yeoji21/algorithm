package inflean.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7 {
    static int[][] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        memo = new int[N+1][R+1];

        System.out.println(nCr(N, R));
    }

    private static int nCr(int n, int r) {
        if(memo[n][r] != 0) return memo[n][r];
        else if(n == 0 || n == r) {
            memo[n][r] = 1;
            return 1;
        }
        else if(r == 1){
            memo[n][r] = n;
            return n;
        }
        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
}