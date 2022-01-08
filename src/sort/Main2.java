package sort;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[] num = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main2().solution(n, num);
    }

    public void solution(int n, Integer[] num) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if(num[j] > num[j+1]) swap(num, j, j+1);
            }
        }
        Arrays.stream(num).forEach(x -> System.out.print(x + " "));
    }

    private void swap(Integer[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
