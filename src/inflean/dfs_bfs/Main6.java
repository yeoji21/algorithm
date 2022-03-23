package inflean.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main6 {
    static int N, M;
    static int[] arr, result;
    static boolean[] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        checked = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        DFS(0);
    }

    private static void DFS(int L) {
        if (L == M) {
            IntStream.range(0, M).forEach(i -> System.out.print(result[i] + " "));
            System.out.println();
        }
        else{
            for (int i = 0; i < N; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    result[L] = arr[i];
                    DFS(L + 1);
                    checked[i] = false;
                }
            }
        }
    }
}