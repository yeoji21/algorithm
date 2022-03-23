package inflean.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main4 {
    static int N, M;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        DFS(0);
    }

    private static void DFS(int L) {
        if (L == M) {
            IntStream.range(0, M).forEach(i -> System.out.print(result[i] + " "));
            System.out.println();
        }else{
            for (int i = 1; i < N + 1; i++) {
                result[L] = i;
                DFS(L + 1);
            }
        }
    }
}