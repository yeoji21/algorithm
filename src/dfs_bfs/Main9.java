package dfs_bfs;

import java.util.*;

public class Main9 {
    static int[][] checked = new int[11][11];
    static int n, m;
    static int[] arr, dup;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        dup = new int[n + 1];

        new Main9().solution(0);
    }

    public void solution(int L) {
        if (L == m) {
            if (checked[arr[0]][arr[1]] == 0) {
                checked[arr[0]][arr[1]] = 1;
                checked[arr[1]][arr[0]] = 1;
                Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
                System.out.println();
            }
        }
        else{
            for (int i = 1; i <= n; i++) {
                if (dup[i] == 0) {
                    dup[i] = 1;
                    arr[L] = i;
                    solution(L+1);
                    dup[i] = 0;
                }
            }
        }
    }
}
