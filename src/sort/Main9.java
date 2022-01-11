package sort;

import java.io.*;
import java.util.*;

public class Main9 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
        int[] music = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
        new Main9().solution(nm[0], nm[1], music);
    }

    public void solution(int n, int m, int[] music) {
        int lt = Arrays.stream(music).max().getAsInt();
        int rt = Arrays.stream(music).sum();

        int result = Integer.MAX_VALUE;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int count = count(music, mid);
            if(count <= m) {
                result = Math.min(result, mid);
                rt = mid-1;
            }
            else lt = mid+1;
        }

        System.out.println(result);
    }

    private int count(int[] music, int mid) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < music.length; i++) {
            sum += music[i];
            if(sum > mid){
                count++;
                sum = music[i];
            }
        }
        return count;
    }
}
