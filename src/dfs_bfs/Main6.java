package dfs_bfs;

import java.util.*;

public class Main6 {
    static int n, m;
    static int[] num, arr, checked;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        num = new int[n];
        checked = new int[n];
        arr = new int[m];

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        new Main6().solution( 0);
    }

    public void solution(int L) {
        if(L == m){
            Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
            System.out.println();
        }
        else{
            for (int i = 0; i < n; i++) {
                if (checked[i] == 0){
                    checked[i] = 1;
                    arr[L] = num[i];
                    solution(L+1);
                    checked[i] = 0;
                }
            }
        }
    }
}