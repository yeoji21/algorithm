package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main1806 {
    private StringBuilder answer = new StringBuilder();
    /*
    길이가 N(10만)인 수열
    수열에서 연속된 수들의 합이 s(1억) 이상이 되는 것 중
    가장 짧은 것의 길이
    int 범위
     */
    private int n, s;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        s = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        solution();
    }

    private void solution() {
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(right < n){
            if(sum < s){
                sum += arr[right];
            }
            if(sum >= s){
                while(sum >= s){
                    min = Math.min(min, right - left + 1);
                    sum -= arr[left++];
                }
            }
            right++;
        }

        while(sum >= s){
            min = Math.min(min, right - left + 1);
            sum -= arr[left++];
        }
        if(min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }

    public static void main(String[] args) throws Exception {
        new Main1806().input(new FastReader());
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