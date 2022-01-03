package two_pointer;

import java.io.*;
import java.util.*;

public class Main6 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nk = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] arr = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main6().solution(nk[0], nk[1], arr);
    }

    public void solution(Integer n, Integer k, Integer[] arr) {
        int max = Integer.MIN_VALUE;
        int lt = 0, rt = 0;

        int sum = 0;
        int count = 0;

        while (lt <= rt && rt < n) {
            if(arr[rt] == 0){
                if (count < k) {
                    rt++;
                    count++;
                    sum++;
                    max = Math.max(max, sum);
                }
                else{
                    if(arr[lt] == 1) {
                        sum--;
                        lt++;
                    }
                    else{
                        sum --;
                        count --;
                        lt++;
                    }
                }
            }
            else{
                sum++;
                rt++;
                max = Math.max(max, sum);
            }

        }

        System.out.println(max);
    }

    public void solution2(Integer n, Integer k, Integer[] arr) {
        int max = 0, count = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) count++;
            while (count > k) {
                if(arr[lt] == 0) count --;
                lt++;
            }
            max = Math.max(max, rt - lt + 1);
        }
        System.out.println(max);
    }
}