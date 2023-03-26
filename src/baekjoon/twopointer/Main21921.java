package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main21921 {
    private int n, x;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        x = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        solution();
    }

    private void solution() {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int sum = 0;
        int left = 0, right = 0;
        while(right < n){
            sum += arr[right++];
            if(sum > max){
                max = sum;
                count = 1;
            }else if(sum == max){
                count++;
            }
            if(right - left + 1 > x){
                sum -= arr[left++];
            }
        }
        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main21921().input(new FastReader());
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
