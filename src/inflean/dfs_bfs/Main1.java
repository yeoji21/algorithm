package inflean.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main1 {
    private static int N;
    private static int totalSum;
    private static int[] arr;
    private static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        totalSum = Arrays.stream(arr).sum();
        calculate(0, 0);

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void calculate(int L, int sum) {
        if(flag) return;
        if(sum > totalSum/2) return;
        if (N == L) {
            if(totalSum - sum == sum)
                flag = true;
        }
        else {
            calculate(L + 1, sum + arr[L]);
            calculate(L + 1, sum);
        }
    }
}