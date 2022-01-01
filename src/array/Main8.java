package array;

import java.io.*;
import java.util.*;

public class Main8 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[] scores = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        new Main8().solution(scores);
    }

    public void solution(Integer[] scores) {
        int[] result = new int[scores.length];

        for (int i = 0; i < result.length; i++) {
            int rank = 1;
            for (int j = 0; j < result.length; j++) {
                if (scores[i] < scores[j])
                    rank++;
            }
            result[i] = rank;
        }

        Arrays.stream(result).forEach(r -> System.out.print(r + " "));
    }
}
