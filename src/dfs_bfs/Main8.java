package dfs_bfs;

import java.util.*;

public class Main8 {
    static int n;
    static int f;
    static int[] base, target, checked;
    static int[][] sum = new int[11][11];
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();

        base = new int[n];
        target = new int[n];
        checked = new int[n];

        for (int i = 0; i < n; i++) {
            target[i] = getTarget(n-1, i);
        }

        new Main8().solution(0);
    }

    public void solution(int L) {
        if (flag) return;
        if(L == n){
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += target[j] * base[j];
            }
            if (sum == f){
                flag = true;
                Arrays.stream(base).forEach(x -> System.out.print(x + " "));
                return;
            }
        }
        else{
            for (int i = 0; i < n; i++) {
                if(checked[i] == 0) {
                    base[L] = i+1;
                    checked[i] = 1;
                    solution(L+1);
                    checked[i] = 0;
                }
            }
        }
    }

    private static int getTarget(int n, int r) {
        if(r == 0 || r == n) return 1;
        if(sum[n][r] > 0) return sum[n][r];
        if (r == 1){
            sum[n][r] = n;
            return n;
        }
        return sum[n][r] = getTarget(n - 1, r - 1) + getTarget(n - 1, r);
    }
}
