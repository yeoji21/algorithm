package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main10973 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        if(hasPrevPermutation(arr)){
            for (int i = 0; i < arr.length; i++) {
                answer.append(arr[i]).append(" ");
            }
            answer.append("\n");
            System.out.println(answer.toString());
        }else{
            System.out.println(-1);
        }
    }

    private boolean hasPrevPermutation(int[] arr) {
        int i = arr.length - 1;
        while(i > 0 && arr[i] >= arr[i - 1]) i--;
        if(i == 0) return false;

        int j = arr.length - 1;
        while(arr[j] >= arr[i - 1]) j--;
        swap(arr, i - 1, j);

        j = arr.length - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }
        return true;
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        new Main10973().input(new FastReader());
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
