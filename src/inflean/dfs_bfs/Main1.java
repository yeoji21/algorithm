package inflean.dfs_bfs;

import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    static int N, total;
    static int[] arr;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        total = Arrays.stream(arr).sum();
        calc(0, 0);

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void calc(int L, int sum) {
        if(flag) return;
        if(sum > total /2) return;
        if (L == N) {
            if (total - sum == sum) {
                flag = true;
            }
        }
        else {
            calc(L + 1, sum + arr[L]);
            calc(L + 1, sum);
        }
    }
}
