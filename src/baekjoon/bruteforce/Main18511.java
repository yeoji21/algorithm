package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main18511 {
    private StringBuilder answer = new StringBuilder();
    private int max = 0;
    private int n, k;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        k = reader.nextInt();
        arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        Arrays.sort(arr);
        int length = (int) Math.log10(n);
        solution(length, 0, 0);
        System.out.println(max);
    }

    private void solution(int length, int sum, int count) {
        if(length == count - 1){
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < arr.length; i++){
            int value = arr[i] * (int) Math.pow(10, count);
            if(sum + value <= n){
                solution(length, sum + value, count + 1);
            }else{
                solution(length, sum, count + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main18511().input(new FastReader());
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
