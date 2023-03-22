package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main19637 {
    private StringBuilder answer = new StringBuilder();
    /*
    n, m 10만
     */
    private int n, m;
    private String[] title;
    private int[] level;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        title = new String[n];
        level = new int[n];
        for (int i = 0; i < n; i++) {
            title[i] = reader.next();
            level[i] = reader.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int user = reader.nextIntLine();
            solution(user);
        }
        System.out.println(answer.toString());
    }

    private void solution(int user) {
        int left = 0, right = n;

        while(left < right){
            int mid = (left + right) / 2;

            if(user > level[mid]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        answer.append(title[right]).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main19637().input(new FastReader());
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
