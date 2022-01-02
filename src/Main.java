import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nm = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] nums = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        new Main().solution(nm[0], nm[1], nums);
    }


    public void solution(Integer n, Integer m, Integer[] nums) {
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