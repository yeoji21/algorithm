package sort;

import java.io.*;
import java.util.*;

public class Main8 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
        int[] nums = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
        new Main8().solution(nm[0], nm[1], nums);
    }

    public void solution(int n, int m, int[] nums) {
        System.out.println(Arrays.stream(nums).sorted().filter(x->x<=m).toArray().length);
    }

    public void solution2(int n, int m, int[] nums) {
        Arrays.sort(nums);
        int lt = 0, rt = n-1;
        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(nums[mid] == m) {
                System.out.println(mid+1);
                return;
            }
            else if(nums[mid] > m) rt = mid-1;
            else lt = mid+1;
        }
    }
}
