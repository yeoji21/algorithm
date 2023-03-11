package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main16953 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int a = reader.nextInt();
        int b = reader.nextInt();
        solution(a, b);
    }

    private void solution(int a, int b) {
        int count = 0;
        while(b > a){
            if(b % 2 == 0){
                b /= 2;
            }else{
                if(b % 10 == 1){
                    b /= 10;
                }else{
                    count = -2;
                    break;
                }
            }
            count++;
        }
        if(b != a) count = -2;

        System.out.println(count + 1);
    }

    public static void main(String[] args) throws Exception {
        new Main16953().input(new FastReader());
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
