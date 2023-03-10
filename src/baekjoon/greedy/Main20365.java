package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main20365 {
    private StringBuilder answer = new StringBuilder();
    /*
    연속된 문제들을 같은 색으로 칠
    5 * 10^5
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        String s = reader.nextLine();
        solution(s);
    }

    private void solution(String s) {
        int result = Math.min(getCount(s, 'R'), getCount(s, 'B'));
        System.out.println(result);
    }

    private int getCount(String s, char r) {
        int count = 1;
        int i = 0;
        while (i < s.length()){
            while(s.charAt(i) == r){
                if(i + 1 < s.length() && s.charAt(i + 1) == r)
                    i++;
                else {
                    count++;
                    break;
                }
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new Main20365().input(new FastReader());
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
