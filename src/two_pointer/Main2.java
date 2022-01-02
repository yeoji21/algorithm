package two_pointer;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[] array1 = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int m = Integer.parseInt(in.readLine());
        Integer[] array2 = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        new Main2().solution(n, array1, m, array2);
    }

    public void solution(int n, Integer[] array1, int m, Integer[] array2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++)
            map.put(array1[i], 1);

        for (int i = 0; i < m; i++) {
            if (map.containsKey(array2[i])) {
                map.put(array2[i], map.get(array2[i]) + 1);
                result.add(array2[i]);
            }
            else
                map.put(array2[i], 1);
        }

        result.stream().sorted(Comparator.comparing(x->x)).forEach(r -> System.out.print(r + " "));
    }

    public void solution2(int n, int[] array1, int m, int[] array2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(array1);
        Arrays.sort(array2);

        int dn = 0, dm = 0;
        while (dn < n && dm < m) {
            if (array1[dn] == array2[dm]) {
                result.add(array1[dn]);
                dn++; dm++;
            }
            else if(array1[dn] < array2[dm]) dn++;
            else if(array1[dn] > array2[dm]) dm++;
        }

        result.forEach(r -> System.out.print(r + " "));
    }
}
