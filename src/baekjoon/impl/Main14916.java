package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main14916 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        solution(n);
    }

    private void solution(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        for(int i = 2; i < arr.length; i++){
            if(arr[i - 2] != -1){
                arr[i] = arr[i - 2] + 1;
            }
            if(i >= 5 && arr[i - 5] != -1){
                arr[i] = arr[i - 5] + 1;
            }
        }
        System.out.println(arr[n]);
    }

    public static void main(String[] args) throws Exception {
        new Main14916().input(new FastReader());
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
