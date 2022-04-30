package inflean.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main14 {
    private static int N, M;
    private static int[][] map;
    private static List<Point> houses, pizza;
    private static int[] selectedPizza;
    private static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        selectedPizza = new int[M];
        houses = new ArrayList<>(N * N);
        pizza = new ArrayList<>(N * N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[j][i] = value;
                if(value == 1) houses.add(new Point(j, i));
                if(value == 2) pizza.add(new Point(j, i));
            }
        }

        selectPizza(0, 0);
        System.out.println(minDistance);
    }

    private static void selectPizza(int L, int S) {
        if (L == M) {
            minDistance = Math.min(calculateDistance(), minDistance);
        }
        else{
            for (int i = S; i < pizza.size(); i++) {
                selectedPizza[L] = i;
                selectPizza(L + 1, i + 1);
            }
        }
    }

    private static int calculateDistance() {
        return houses.stream().map(
                        house -> Arrays.stream(selectedPizza)
                                .map(index -> Math.abs(pizza.get(index).x - house.x) + Math.abs(pizza.get(index).y - house.y))
                                .min()
                                .getAsInt())
                .mapToInt(n -> n).sum();
    }

    static class Point{
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}