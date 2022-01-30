package inflean.dfs_bfs;

import java.util.*;

public class Main1 {
    static int n, total;
    static int[] num;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        total = Arrays.stream(num).sum();
        new Main1().DFS(0, 0);
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public void DFS(int level, int sum) {
        if (flag) return;
        if (sum > total/2) return;
        if (level == n) {
            if (total - sum == sum)
                flag = true;
        }
        else{
            DFS(level+1, sum + num[level]);
            DFS(level+1, sum);
        }
    }
}
