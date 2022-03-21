package inflean.rtg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12 {
    static int N, M, result = 0;
    static boolean[][] map;
    static boolean[] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);
        M = getIntToken(st);
        map = new boolean[N + 1][N + 1];
        checked = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = getIntToken(st);
            int y = getIntToken(st);
            map[x][y] = true;
        }

        checked[1] = true;
        DFS(1);
        System.out.println(result);
    }

    private static void DFS(int L) {
        if (L == N) {
            result++;
        }else{
            for (int i = 1; i < N + 1; i++) {
                if (map[L][i] && !checked[i]) {
                    checked[i] = true;
                    DFS(i);
                    checked[i] = false;
                }
            }
        }
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}