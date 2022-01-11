package sort;

import java.io.*;
import java.util.*;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] nc = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] num = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        new Main10().solution(nc[0], nc[1], num);
    }

    public void solution(int n, int c, int[] num) {
        Arrays.sort(num);
        List<Integer> results = new ArrayList<>();
        int lt=1, rt = num[n-1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(getCount(num, mid) >= c) {
                results.add(mid);
                lt = mid+1;
            }
            else{
                rt = mid-1;
            }
        }
        System.out.println(results.stream().mapToInt(x->x).max().getAsInt());
    }

    private int getCount(int[] num, int mid) {
        int count = 1;
        int preIdx = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i] - num[preIdx] >= mid) {
                preIdx = i;
                count ++;
            }
        }
        return count;
    }
}
