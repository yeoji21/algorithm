package programmers_level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 위장 {
    public int solution(String[][] clothes) {
//        Map<String, Integer> map = new HashMap<>();
//
//        for (String[] clothe : clothes) {
//            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
//        }
//
//        int result = 1;
//
//        for (Integer value : map.values()) {
//            result *= value + 1;
//        }
//
//        return result - 1;

        return Arrays.stream(clothes)
                .collect(Collectors.groupingBy(c -> c[1], Collectors.mapping(c -> c[0], Collectors.counting())))
                .values()
                .stream()
                .reduce(1L, (x, y) -> x * (y + 1))
                .intValue() - 1;
    }
}
