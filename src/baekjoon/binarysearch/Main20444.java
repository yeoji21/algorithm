package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main20444 {
    private StringBuilder answer = new StringBuilder();
    /*
    n(int) 번의 가위질로 k(long)개의 색종이 조각을 만들 수 있는지
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        long k = reader.nextLong();

        long start = 0;
        long end = n / 2 + 1;
        while(start < end){
            long row = (start + end) / 2;
            long col = n - row;
            long count = (row + 1) * (col + 1);

            if (k == count) {
                System.out.println("YES");
                return;
            }
            if(k > count){
                start = row + 1;
            }else{
                end = row;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) throws Exception {
        new Main20444().input(new FastReader());
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
