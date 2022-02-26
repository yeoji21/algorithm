import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[101][101];
    static int R, C, K;
    static final int LIMIT = 100;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = getIntegerToken(st);
        C = getIntegerToken(st);
        K = getIntegerToken(st);

        for (int i = 1; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 4; j++) {
                map[i][j] = getIntegerToken(st);
            }
        }

        sort();
        // https://bcp0109.tistory.com/216
        // https://velog.io/@hyunjkluz/%EB%B0%B1%EC%A4%8017140-%EC%9D%B4%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4%EA%B3%BC-%EC%97%B0%EC%82%B0-Java
        // https://comgong-man.tistory.com/235
    }

    private static void sort() {
        while (result++ < LIMIT) {
            int row = map.length;
            int column = map[0].length;

            if(row >= column) RSort();
            else CSort();

            if(map[R][C] == K) return;
        }
    }

    private static void RSort() {

    }

    private static void CSort() {

    }

    private static int getIntegerToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}