package programmers_level1;

import java.util.*;

public class 직사각형 {
    public static void main(String[] args) {
        int[][] value = {{1, 4}, {3, 4}, {3, 10}};
        int[] solution = solution(value);
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static int[] solution(int[][] v) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();

        Arrays.stream(v).forEach(point ->
        {
            row.put(point[0], row.getOrDefault(point[0], 0) + 1);
            col.put(point[1], col.getOrDefault(point[1], 0) + 1);
        });

        Integer resultR = row.entrySet().stream().filter(r -> r.getValue() == 1)
                .map(Map.Entry::getKey).findAny().get();

        Integer resultC = col.entrySet().stream().filter(r -> r.getValue() == 1)
                .map(Map.Entry::getKey).findAny().get();

        return new int[]{resultR, resultC};
    }
}
