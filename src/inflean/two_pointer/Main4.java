package inflean.two_pointer;

import java.io.*;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nm = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] nums = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        new Main4().solution(nm[0], nm[1], nums);
    }

    public void solution(Integer n, Integer m, Integer[] nums) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            for (int j = i+1; j < n; j++) {
                sum += nums[j];
                if (sum > m) break;
                if (sum == m) {
                    count++;
                    break;
                }
            }
            sum = 0;
        }
        System.out.println(count);
    }

    public void solution2(Integer n, Integer m, Integer[] nums) {
        int count = 0;
        int sum = nums[0];
        int lt = 0, rt = 1;

        while (lt < rt && rt<n) {
            sum += nums[rt++];
            if(sum == m){
                count ++;
                sum -= nums[lt++];
            }

            while(sum > m){
                sum -= nums[lt++];
                if(sum == m){
                    count ++;
                    sum -= nums[lt++];
                }
            }
        }
        System.out.println(count);
    }
}
