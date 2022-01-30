package inflean.array;

import java.io.*;
import java.util.*;

public class Main9 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[][] nums = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        }

        new Main9().solution(nums, n);
    }

    public void solution(Integer[][] nums, int n) {
        int max = Integer.MIN_VALUE;

        int left = 0, right = 0;

        for (int i = 0; i < n; i++) {
            left += nums[i][i];
            right += nums[i][n - i -1];
        }
        max = Integer.max(Integer.max(left, right), max);

        for (int i = 0; i < n; i++) {
            int hang = 0;
            int yeol = 0;
            for (int j = 0; j < n; j++) {
                hang += nums[i][j];
                yeol += nums[j][i];
            }
            max = Integer.max(Integer.max(hang, yeol), max);
        }
        System.out.println(max);
    }
}
