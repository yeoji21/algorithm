package inflean.sort;

import java.io.*;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] sn = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] num = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main4().solution(sn[0], sn[1], num);
    }

    public void solution(int s, int n, Integer[] num) {
        int[] cache = new int[s];
        for (int i = 0; i < n; i++) {
            int target = num[i];
            int idx = s-1;
            for (int m = 0; m < s; m++) {
                if (cache[m] == target) idx = m;
            }

            for (int j = idx; j > 0; j--) {
                cache[j] = cache[j-1];
            }
            cache[0] = target;
        }

        Arrays.stream(cache).forEach(x -> System.out.print(x + " "));
    }

    private void swap(Integer[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
