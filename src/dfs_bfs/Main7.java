package dfs_bfs;

import java.util.*;

public class Main7 {
    int[][] checked = new int[34][34];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(new Main7().solution(n, r));
    }

    public int solution(int n, int r) {
        if(checked[n][r] != 0) return checked[n][r];
        if(r == 0 || r == n) {
            checked[n][r] = 1;
            return 1;
        }
        if(r == 1) {
            checked[n][r] = n;
            return n;
        }

        return solution(n - 1, r - 1) + solution(n -1, r);
    }
}
