package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main11508 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextIntLine();
        }
        solution(arr);
    }

    private void solution(Integer[] arr) {
        Arrays.sort(arr, Comparator.reverseOrder());

        int sum = arr[0];
        for(int i = 1; i < arr.length; i++){
            if((i + 1) % 3 == 0) continue;
            sum += arr[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main11508().input(new FastReader());
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
