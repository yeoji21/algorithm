import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, result = Integer.MAX_VALUE;
    static int[][] map;
    static int[] combi;
    static List<Point> pizza, house;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);
        M = getIntToken(st);

        map = new int[N][N];
        combi = new int[M];
        pizza = new ArrayList<>();
        house = new ArrayList<>(100);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = getIntToken(st);
                map[i][j] = value;
                if(value == 1) house.add(new Point(i, j));
                else if(value == 2) pizza.add(new Point(i, j));
            }
        }

        DFS(0, 0);
        System.out.println(result);
    }

    private static void DFS(int L, int n) {
        if (L == M) {
            int sum = house.stream().map(h -> Arrays.stream(combi)
                            .map(i -> Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y))
                            .min().getAsInt())
                    .mapToInt(x -> x).sum();
            result = Math.min(result, sum);
        }else{
            for (int i = n; i < pizza.size(); i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}