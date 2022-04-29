package inflean.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main5 {
    private static int N, M;
    private static int[] coins;
    private static int minLevel = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);

        coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) coins[i] = getIntToken(st);

        st = new StringTokenizer(br.readLine());
        M = getIntToken(st);

        DFS(0, 0);
        System.out.println(minLevel);
    }

    private static void DFS(int L, int sum) {
        if(L >= minLevel) return;
        if(sum > M) return;
        if(sum == M) minLevel = Math.min(minLevel, L);
        else{
            for (int i = coins.length-1; i >= 0; i--) {
                DFS(L+1, sum + coins[i]);
            }
        }
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}