package sort;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[] num = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main3().solution(n, num);
    }

    public void solution(int n, Integer[] num) {
        for (int i = 1; i < n; i++) {
            int target = num[i];
            int j = 0;
            for (j = i-1; j >=0 && num[j]>target; j--)
                num[j + 1] = num[j];
            num[j + 1] = target;
        }

        Arrays.stream(num).forEach(x -> System.out.print(x + " "));
    }
}
