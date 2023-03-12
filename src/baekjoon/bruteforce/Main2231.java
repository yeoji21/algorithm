package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main2231 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        solution(n);
    }

    private void solution(int n) {

        for(int i = 1; i <= n; i++){
            int sum = i;
            int temp = i;
            while(temp != 0){
                sum += temp % 10;
                temp /= 10;
            }
            if(sum == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws Exception {
        new Main2231().input(new FastReader());
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