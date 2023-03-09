package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main2469 {
    private StringBuilder answer = new StringBuilder();

    private static int k, n, line;
    private int[] todown, toup;
    private char[][] map;
    private char[] ans;

    /*
    https://lktgt.tistory.com/m/51
    https://velog.io/@solser12/백준-2469-사다리-타기-JAVA
     */
    private void input(FastReader reader) throws Exception{
        k = reader.nextIntLine();
        n = reader.nextIntLine();
        todown = new int[k];
        toup = new int[k];
        map = new char[n][k - 1];
        ans = new char[k - 1];

        String s = reader.nextLine();
        for (int i = 0; i < s.length(); i++) {
            todown[i] = i;
            toup[i] = s.charAt(i) - 'A';
        }

        for (int i = 0; i < n; i++) {
            map[i] = reader.nextLine().toCharArray();
            if(map[i][0] == '?') line = i;
        }

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < k - 1; j++) {
                if(map[i][j] == '-') swap(todown, j, j + 1);
            }
        }

        for (int i = n - 1; i > line; i--) {
            for (int j = 0; j < k - 1; j++) {
                if(map[i][j] == '-') swap(toup, j, j + 1);
            }
        }

        for (int i = 0; i < k - 1; i++) {
            if (i > 0 && ans[i - 1] == '-') {
                ans[i] = '*';
                continue;
            }
            if (todown[i] != toup[i]) {
                ans[i] = '-';
                swap(todown, i, i + 1);
            }else{
                ans[i] = '*';
            }
        }

        for (int i = 0; i < k - 1; i++) {
            if(todown[i] != toup[i]){
                for (int j = 0; j < k - 1; j++) ans[j] = 'x';
                break;
            }
        }
        for (int i = 0; i < k - 1; i++) {
            answer.append(ans[i]);
        }
        System.out.println(answer.toString());
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        new Main2469().input(new FastReader());
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
