package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main3079 {
    /*
    m(10억)명의 친구들, n(10만)개의 입국 심사대
    가장 앞에 서 있는 사람은 비어있는 심사대로 가거나, 더 빠른 심사대가 끝나길 기다려도 됨
     */
    private int n, m;
    private long[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        arr = new long[n];
        long left = Integer.MAX_VALUE;
        long right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextIntLine();
            left = Math.min(left, arr[i]);
            right = Math.max(right, arr[i]);
        }
        solution(0, right * m + 1);
    }

    private void solution(long left, long right) {
        while(left < right){
            long mid = (right - left) / 2 + left;
            long count = 0;
            for(long a : arr){
                count += mid / a;
                if(count >= m) break;
            }
            if(count < m){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        System.out.println(right);
    }

    public static void main(String[] args) throws Exception {
        new Main3079().input(new FastReader());
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
