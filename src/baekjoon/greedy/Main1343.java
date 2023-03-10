package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main1343 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        String s = reader.nextLine();
        solution(s);
    }

    private void solution(String s) {
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '.') {
                answer.append(".");
                i++;
                continue;
            }

            int count = 1;
            while(true){
                if(i + 1 < s.length() && s.charAt(i + 1) == 'X'){
                    i++;
                    count++;
                }else{
                    break;
                }
            }
            if(!calc(count)){
                System.out.println(-1);
                return;
            }
            i++;
        }

        System.out.println(answer.toString());
    }

    boolean calc(int count){
        if(count % 2 == 1) return false;
        while(count > 0){
            if(count >= 4) {
                answer.append("AAAA");
                count -= 4;
            }
            else if(count >= 2) {
                answer.append("BB");
                count -= 2;
            }
            else break;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main1343().input(new FastReader());
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
