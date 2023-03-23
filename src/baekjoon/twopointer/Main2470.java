package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main2470 {
    private StringBuilder answer = new StringBuilder();
    /*
    산성 양수 (10억)
    알칼리성 음수(10억)
    같은 양의 두 용액을 섞어서 0에 가깝게 만들기
     */
    private int n;
    private int[] arr;
    private int min = Integer.MAX_VALUE;
    private int a = 0, b = 0;
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        solution();
    }

    private void solution() {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while(left < right){
            int sum = arr[left] + arr[right];
            int gap = Math.abs(sum);
            if(min > gap){
                min = gap;
                a = arr[left];
                b = arr[right];
            }
            if(sum > 0){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(a + " " + b);
    }

    public static void main(String[] args) throws Exception {
        new Main2470().input(new FastReader());
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextIntLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Integer.parseInt(str);
        }
    }
}
