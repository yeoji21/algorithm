package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main2661 {
    private StringBuilder answer = new StringBuilder();
    private int n;
    private boolean find = false;
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        DFS(0, "");
    }

    private void DFS(int depth, String selected) {
        if(find) return;
        if(depth == n){
            System.out.println(selected);
            find = true;
            return;
        }
        for(int i = 1; i < 4; i++){
            if(!check(selected + i)) continue;
            DFS(depth + 1, selected + i);
        }
    }

    boolean check(String s){
        StringBuilder a = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            a.append(s.charAt(i));
            StringBuilder b = new StringBuilder();
            if(i - 1 < 0 || a.length() * 2 > s.length()) break;

            for(int j = 1; j <= a.length(); j++){
                b.append(s.charAt(i - j));
            }

            if(a.toString().equals(b.toString())) return false;
        }
        return true;
    }

    boolean check2(String s){
        for (int i = 1; i <= s.length() / 2; i++) {
            String back = s.substring(s.length() - i, s.length());
            String front = s.substring(s.length() - (i * 2), s.length() - i);
            if(back.equals(front)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main2661().input(new FastReader());
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
