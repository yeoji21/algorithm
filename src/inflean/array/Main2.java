package inflean.array;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        List<Integer> intNumList = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        new Main2().solution(intNumList);
    }

    public void solution(List<Integer> intNumList) {
        int max = Integer.MIN_VALUE;
        int total = 0;
        for (Integer num : intNumList) {
            if (num > max) {
                total++;
                max=num;
            }
        }
        System.out.println(total);
    }
}
