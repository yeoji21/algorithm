package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main13164 {
    private StringBuilder answer = new StringBuilder();
    /*
    n명 키순으로 세우고 k개의 조로 나누기
    각 조는 최소 한명, 같은 조에 속하는 원생끼리는 모여 있어야 함
    조의 비용은 가장 키 큰 애 - 가장 키 작은 애
    K개의 조의 비용의 합을 최소로
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        int k = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        solution(arr, k);
    }

    private void solution(int[] arr, int k) {
        int[] gap = new int[arr.length - 1];
        for(int i = 0; i < arr.length - 1; i ++){
            gap[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(gap);
        int sum = 0;
        for(int i = 0; i < arr.length - k; i++){
            sum += gap[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main13164().input(new FastReader());
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
