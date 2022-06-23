package programmers_level1;

import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .map(command ->
                    Arrays.stream(array, command[0] - 1, command[1])
                            .sorted()
                            .toArray()[command[2] - 1])
                .mapToInt(x -> x)
                .toArray();
    }
}
