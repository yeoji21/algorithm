package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main20922 {
    private StringBuilder answer = new StringBuilder();
    /*
    같은 원소가 k개 이하인
    최장 연속 부분 수열의 길이 구하기
    길이 N(20만) K(100)
     */
    private int n, k;
    private int[] count = new int[100_001];
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        k = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        solution();
    }

    private void solution() {
        int max = 0;
        int left = 0, right = 0;

        while(right < n){
            if(++count[arr[right]] > k){
                while(count[arr[right]] > k){
                    count[arr[left++]]--;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main20922().input(new FastReader());
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
