package inflean.sort;

import java.io.*;
import java.util.*;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[] num = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main5().solution(n, num);
    }

    public void solution(int n, Integer[] num) {
        int[] result = new int[10_000_001];

        for (int i = 0; i < n; i++) {
            result[num[i]] ++;
            if(result[num[i]] > 1){
                System.out.println("D");
                return;
            }
        }
        System.out.println("U");
    }
}
