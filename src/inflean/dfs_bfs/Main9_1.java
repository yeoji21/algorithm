package inflean.dfs_bfs;

import java.util.*;

public class Main9_1 {
    static int n, m;
    static int[] combi;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];

        new Main9_1().solution(0, 1);
    }

    public void solution(int L, int s) {
        if (L == m) {
            Arrays.stream(combi).forEach(x -> System.out.print(x + " "));
            System.out.println();
        }
        else{
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                solution(L+1, i+1);
            }
        }
    }
}
