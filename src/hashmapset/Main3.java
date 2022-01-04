package hashmapset;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nm = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] sales = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main3().solution(nm[0], nm[1], sales);
    }

    public void solution(Integer n, Integer m, Integer[] sales) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            map.put(sales[i], map.getOrDefault(sales[i], 0)+1);
        }
        int lt = 0, rt = m - 1;

        while (lt < rt && rt < n) {
            System.out.print(map.keySet().size() + " ");

            ++rt;
            if(rt >= n) break;
            map.put(sales[rt], map.getOrDefault(sales[rt], 0)+1);

            map.put(sales[lt], map.get(sales[lt]) - 1);
            if(map.get(sales[lt]) <= 0) map.remove(sales[lt]);
            lt++;
        }
    }
}
