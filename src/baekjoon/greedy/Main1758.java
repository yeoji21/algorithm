package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main1758 {
    private StringBuilder answer = new StringBuilder();

    /*
    n명의 손님의 순서를 재배치해서 강호가 받을 수 있는 팁의 최댓값을 구하시오
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextIntLine();
        }
        solution(arr);
    }

    private void solution(Integer[] arr) {
        long sum = 0;
        Arrays.sort(arr, Comparator.reverseOrder());
        for(int i = 0; i < arr.length; i++){
            if((arr[i] - i) < 0) break;
            sum += (arr[i] - i);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main1758().input(new FastReader());
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
