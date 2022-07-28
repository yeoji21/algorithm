package programmers_level2;

import java.util.HashMap;
import java.util.Map;

public class 전력망을_둘로_나누기 {
    public static void main(String[] args) {
        solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}});
    }

    public static int solution(int n, int[][] wires) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int[] check = initialize(n);
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < wires.length; j++) {
                if(i == j) continue;
                int[] wire = wires[j];
                int min = Math.min(check[wire[0]], check[wire[1]]);
                check[wire[0]] = min;
                check[wire[1]] = min;
                map.put(min, map.getOrDefault(min, 0) + 1);
            }

            if(map.values().size() == 2) {
                result = Math.min(result, map.values().stream().reduce((x, y) -> Math.abs(x - y)).get());
                if(result == 0) break;
            }
        }

        return result;
    }

    private static int[] initialize(int n) {
        int[] check = new int[n + 1];
        for (int j = 1; j < check.length; j++) {
            check[j] = j;
        }
        return check;
    }
}
