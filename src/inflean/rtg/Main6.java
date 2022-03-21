package inflean.rtg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main6 {
    static int T;
    static int[] checked;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        checked = new int[T + 1];
        DFS(1);
    }

    private static void DFS(int L) {
        if (L == T + 1) {
            IntStream.range(1, T+1).filter(i -> checked[i] == 1).forEach(i -> System.out.print(i + " "));
            System.out.println();
        }else{
            checked[L] = 1;
            DFS(L + 1);
            checked[L] = 0;
            DFS(L + 1);
        }
    }
}