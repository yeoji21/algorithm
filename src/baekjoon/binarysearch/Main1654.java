package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main1654 {
    private StringBuilder answer = new StringBuilder();
    /*
    k개의 랜선을 같은 길이의 n개의 랜선으로
     */
    private int k, n;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        k = reader.nextInt();
        n = reader.nextInt();
        arr = new int[k];
        int right = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = reader.nextIntLine();
            right = Math.max(right, arr[i]);
        }
        solution(right);
    }

    private void solution(long right) {
        long left = 0;
        right += 1;

        while(left < right){
            long mid = (right - left) / 2 + left;
            long count = 0;
            for(int line : arr){
                count += line / mid;
            }
            if(count >= n){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(right - 1);
    }

    public static void main(String[] args) throws Exception {
        new Main1654().input(new FastReader());
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
