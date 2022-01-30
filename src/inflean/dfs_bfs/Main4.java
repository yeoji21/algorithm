package inflean.dfs_bfs;

import java.util.Scanner;

public class Main4 {
    static int[] pm;
    static int n, m;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];

        new Main4().solution(0);
    }

    public void solution(int level) {
        if(level == m){
            for (int x : pm)
                System.out.print(x + " ");
            System.out.println();
        }
        else{
            for (int i = 1; i <= n; i++) {
                pm[level] = i;
                solution(level+1);
            }
        }
    }
}
