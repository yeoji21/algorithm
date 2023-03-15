package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main12919 {
    private StringBuilder answer = new StringBuilder();
    private int flag = 0;
    private void input(FastReader reader) throws Exception{
        String s = reader.nextLine();
        String t = reader.nextLine();
        solution(s, t);
        System.out.println(flag > 0 ? "1" : "0");
    }

    private void solution(String s, String t) {
        if(s.length() == t.length()){
            flag += s.equals(t) ? 1 : 0;
            return;
        }

        if(t.charAt(t.length() - 1) == 'A'){
            solution(s, t.substring(0, t.length() - 1));
        }
        if(t.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder();
            for(int i = t.length() - 1; i >= 1; i--){
                sb.append(t.charAt(i));
            }
            solution(s, sb.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main12919().input(new FastReader());
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
