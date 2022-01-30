package inflean.dfs_bfs;

import java.util.*;

public class Main5 {
    static int[] money;
    static int n, m, minLevel = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        money = new int[n];
        for (int i = 0; i < n; i++)
            money[i] = sc.nextInt();
        m = sc.nextInt();
        new Main5().solution(0, 0);
        System.out.println(minLevel);
    }

    public void solution(int level, int totalMoney) {
        if(totalMoney > m) return;
        if(level >= minLevel) return;
        if(totalMoney == m){
            minLevel = Math.min(minLevel, level);
        }
        else {
            for (int i = n-1; i >= 0; i--) {
                solution(level+1, totalMoney+money[i]);
            }
//            solution(level + 1, totalMoney + money[2]);
//            solution(level + 1, totalMoney + money[1]);
//            solution(level + 1, totalMoney + money[0]);
        }
    }
}