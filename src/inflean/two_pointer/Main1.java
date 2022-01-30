package inflean.two_pointer;

import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[] array1 = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int m = Integer.parseInt(in.readLine());
        Integer[] array2 = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        new Main1().solution(n, array1, m, array2);
    }

    public void solution(int n, Integer[] array1, int m, Integer[] array2) {
        int[] result = new int[n + m];
        int idx = 0;
        int dn = 0, dm = 0;

        while (dn < n && dm < m) {
            if (array1[dn] < array2[dm])
                result[idx++] = array1[dn++];
            else
                result[idx++] = array2[dm++];
        }

        while (dn < n)
            result[idx++] = array1[dn++];

        while (dm < m)
            result[idx++] = array2[dm++];

        Arrays.stream(result).forEach(r -> System.out.print(r + " "));
    }
}
