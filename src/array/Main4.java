package array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());

        new Main4().solution(num);
    }

    public void solution(int num) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);

        while (result.size() < num) {
            int sum = result.get(result.size() - 1) + result.get(result.size() - 2);
            result.add(sum);
        }

        result.forEach(s -> System.out.print(s + " "));
    }
}