package programmers_level1;

import java.util.*;

public class 실패율 {
    public static void main(String[] args) {
        solution(4, new int[]{4,4,4,4,4});
    }

    public static int[] solution(int N, int[] stages) {
        int total = stages.length;
        Map<Integer, Integer> map = initializeMap(stages);
        List<Round> result = new ArrayList<>();

        for (int round = 1; round < N + 1; round++) {
            Integer remain = map.getOrDefault(round, 0);
            double value = getValue(total, remain);
            result.add(new Round(round, value));
            total -= remain;
        }

        return result.stream().sorted(Comparator.comparing(r -> -r.remain))
                .mapToInt(r -> r.round)
                .toArray();
    }

    private static Map<Integer, Integer> initializeMap(int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(stages).forEach(remain -> map.put(remain, map.getOrDefault(remain, 0) + 1));
        return map;
    }

    static class Round{
        int round;
        double remain;

        public Round(int round, double remain) {
            this.round = round;
            this.remain = remain;
        }
    }

    private static double getValue(int total, Integer remain) {
        if(remain == 0) return 0.0;
        else return (double) remain / (double) total;
    }
}
