package inflean.sort;

import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[] num = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main1().solution(n, num);
    }

    public void solution(int n, Integer[] num) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(num[i] > num[j]){
                    swap(num, i, j);
                }
            }
        }
        Arrays.stream(num).forEach(x -> System.out.print(x + " "));
    }

    private void swap(Integer[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public void solution2(int n, Integer[] num) {
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i+1; j < n; j++) {
                if (num[idx] > num[j]) idx = j;
            }
            int temp = num[i];
            num[i] = num[idx];
            num[idx] = temp;
        }
        Arrays.stream(num).forEach(x -> System.out.print(x + " "));
    }
}
