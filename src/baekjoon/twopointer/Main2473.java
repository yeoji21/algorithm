package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main2473 {
    private StringBuilder answer = new StringBuilder();
    /*
    n 5000
    용액은 +- 10억
     */
    private int n;
    private int[] arr;
    private int start, middle, end;
    private long min = Long.MAX_VALUE;
    private int[] result = new int[3];
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        solution();
    }

    private void solution() {
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            start = i;
            middle = i + 1;
            end = n - 1;
            while (middle < end) {
                long sum = (long) arr[start] + arr[middle] + arr[end];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    result[0] = arr[start];
                    result[1] = arr[middle];
                    result[2] = arr[end];
                }
                if(sum == 0){
                    break;
                } else if (sum > 0) {
                    end--;
                } else {
                    middle++;
                }
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    public static void main(String[] args) throws Exception {
        new Main2473().input(new FastReader());
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
