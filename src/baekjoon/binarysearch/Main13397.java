package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main13397 {
    private StringBuilder answer = new StringBuilder();
    /*
    n개의 배열을 m개의 구간으로 나누기
    가장 큰 최댓값과 최솟값의 차이를 최소로
     */
    private int n, m;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        arr = new int[n];
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
            right = Math.max(right, arr[i]);
        }
        solution(0, right + 1);
    }

    private void solution(int left, int right) {
        while(left < right){
            int mid = (left + right) / 2;
            int count = 1;
            int min = arr[0];
            int max = arr[0];
            for(int i = 1; i < arr.length; i++){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
                if(max - min > mid){
                    min = arr[i];
                    max = arr[i];
                    count++;
                }
            }
            if(count <= m){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(right);
    }

    public static void main(String[] args) throws Exception {
        new Main13397().input(new FastReader());
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