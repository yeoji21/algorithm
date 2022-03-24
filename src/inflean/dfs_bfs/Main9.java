package inflean.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9 {
    static int N, M;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        DFS(0, 1);
    }

    private static void DFS(int L, int n) {
        if (L == M) {
            Arrays.stream(result).forEach(num -> System.out.print(num + " "));
            System.out.println();
        }else{
            for (int i = n; i < N + 1; i++) {
                result[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}