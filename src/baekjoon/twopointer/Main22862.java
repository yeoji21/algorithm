package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main22862 {
    private StringBuilder answer = new StringBuilder();
    /*
    길이가 n(100만)인 수열
    원하는 위치의 수를 최대 k(10만)번 삭제
    짝수로 이루어져 있는 연속 부분 수열의 최대 길이
     */
    private int n, k;
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
        int left = 0, right = 0;
        int count = k;
        int max = 0;

        while(right < n){
            if(arr[right] % 2 == 1){
                if(count > 0){
                    count--;
                }
                else{
                    while(count == 0){
                        if(arr[left++] % 2 == 1)
                            count++;
                    }
                    count = 0;
                }
            }

            max = Math.max(max, right - left + 1 - (k - count));
            right++;
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main22862().input(new FastReader());
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
