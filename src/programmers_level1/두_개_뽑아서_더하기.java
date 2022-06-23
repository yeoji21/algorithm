package programmers_level1;

import java.util.HashSet;
import java.util.Set;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(x -> x).sorted().toArray();
    }
}
