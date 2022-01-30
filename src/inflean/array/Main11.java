package inflean.array;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main11 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[][] nums = new Integer[n][5];
        for (int i = 0; i < n; i++)
            nums[i] = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main11().solution(nums, n);
    }

    public void solution(Integer[][] nums, int n) {
        int [] result = new int[n];

        for (int k = 0; k<n; k++) {
            int[] check = new int[n];
            for (int j = 0; j < 5; j++) {
                int target = nums[k][j];
                for (int i = 0; i < n; i++) {
                    if (nums[i][j] == target)
                        check[i] = 1;
                }
            }
            for(int m = 0; m < n; m++){
                if (check[m] == 1)
                    result[m]++;
            }
        }

        List<Integer> resultList = Arrays.stream(result).boxed().collect(Collectors.toList());
        int i = resultList.indexOf(Collections.max(resultList));
        System.out.println(i+1);
    }
}