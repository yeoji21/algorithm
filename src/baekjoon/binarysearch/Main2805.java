package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main2805 {
    private StringBuilder answer = new StringBuilder();
    /*
    나무 수 n
    원하는 길이 m
     */
    private int n, m;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        arr = new int[n];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
            max = Math.max(max, arr[i]);
        }
        soution(max + 1);
    }

    private void soution(int right) {
        int left = 0;

        while(left < right){
            int mid = (right - left) / 2 + left;
            long sum = 0;
            for(int n : arr){
                if(n > mid) sum += n - mid;
            }
            if(sum >= m){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(right - 1);
    }

    public static void main(String[] args) throws Exception {
        new Main2805().input(new FastReader());
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
