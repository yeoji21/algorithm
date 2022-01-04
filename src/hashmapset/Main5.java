package hashmapset;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nk = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        List<Integer> nums = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        new Main5().solution(nk[0], nk[1], nums);
    }

    public void solution(Integer n, Integer k, List<Integer> nums) {
        Set<Integer> set = new TreeSet<>(Comparator.comparing(x->-x));

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int m = j+1; m < n; m++) {
                    set.add(nums.get(i) + nums.get(j) + nums.get(m));
                }
            }
        }

        if(k-1 > set.size()) {
            System.out.println("-1");
            return;
        }

        Integer x = new ArrayList<>(set).get(k - 1);
        System.out.println(x);
    }
}
