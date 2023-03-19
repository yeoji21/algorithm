package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main6443 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        while (n-- > 0) {
            String s = reader.nextLine();
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            DFS(arr, 0, new boolean[arr.length], new char[arr.length]);
        }
        System.out.println(answer.toString());
    }

    private void DFS(char[] arr, int depth, boolean[] checked, char[] selected) {
        if(depth == arr.length){
            for(int i = 0; i < selected.length; i++){
                answer.append(selected[i]);
            }
            answer.append("\n");
            return;
        }

        char temp = (char)-1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == temp || checked[i]) continue;
            temp = arr[i];
            checked[i] = true;
            selected[depth] = arr[i];
            DFS(arr, depth + 1, checked, selected);
            checked[i] = false;
        }
    }


    public static void main(String[] args) throws Exception {
        new Main6443().input(new FastReader());
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
