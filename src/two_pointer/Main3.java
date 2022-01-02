package two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nk = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] nums = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        new Main3().solution(nk[0], nk[1], nums);
    }

    private void solution(Integer n, Integer k, Integer[] nums) {
        int max = Integer.MIN_VALUE;

        int formal = 0;
        for (int i = 0; i < k; i++)
            formal += nums[i];

        for (int i = k; i < n; i++) {
            int now = formal - nums[i - k] + nums[i];
            max = Math.max(formal, Math.max(max, now));
            formal = now;
        }

        System.out.println(max);
    }
}