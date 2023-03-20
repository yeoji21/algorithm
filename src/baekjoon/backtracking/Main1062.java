package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main1062 {
    private StringBuilder answer = new StringBuilder();
    private int n, k;
    private boolean[] alphabet;
    private int max = 0;
    private String[] words;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        k = reader.nextInt();
        if(k < 5) {
            System.out.println(0);
            return;
        }
        words = new String[n];
        for (int i = 0; i < n; i++) {
            String s = reader.nextLine();
            words[i] = s.substring(4, s.length() - 4);
        }
        alphabet = new boolean[26];
        alphabet['a' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['c' - 'a'] = true;

        DFS(0, 0);
        System.out.println(max);
    }

    private void DFS(int start, int depth) {
        if(depth == k - 5){
            int count = 0;
            for(String word : words){
                boolean flag = true;
                for(char ch : word.toCharArray()){
                    if(!alphabet[ch - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
            max = Math.max(max, count);
            return;
        }
        for(int i = start; i < 26; i++){
            if(alphabet[i]) continue;
            alphabet[i] = true;
            DFS(i + 1, depth + 1);
            alphabet[i] = false;
        }

    }

    public static void main(String[] args) throws Exception {
        new Main1062().input(new FastReader());
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
