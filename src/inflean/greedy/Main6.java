package inflean.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main6 {
    static int N, M;
    static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);
        M = getIntToken(st);
        unf = new int[N + 1];
        IntStream.range(1, N + 1).forEach(i -> unf[i] = i);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(getIntToken(st), getIntToken(st));
        }

        st = new StringTokenizer(br.readLine());
        System.out.println(find(getIntToken(st)) == find(getIntToken(st)) ? "YES" : "NO");
    }

    private static void union(int x, int y) {
        int valueX = find(x);
        int valueY = find(y);

        if(valueX != valueY) unf[valueY] = valueX;
    }

    private static int find(int idx) {
        if(idx == unf[idx]) return idx;
        else return unf[idx] = find(unf[idx]);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}