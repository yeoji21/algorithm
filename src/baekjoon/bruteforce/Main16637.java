package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main16637 {
    private StringBuilder answer = new StringBuilder();
    private int n;
    private String s;
    private int max = Integer.MIN_VALUE;
    private List<Integer> num = new ArrayList<>();
    private List<Character> op = new ArrayList<>();

    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        s = reader.nextLine();
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) num.add(s.charAt(i) - '0');
            else op.add(s.charAt(i));
        }
        DFS(0, num.get(0));
        System.out.println(max);
    }

    private void DFS(int opIdx, int sum) {
        if(opIdx >= op.size()){
            max = Math.max(max, sum);
            return;
        }
        DFS(opIdx + 1, calculate(opIdx, sum, num.get(opIdx + 1)));
        if (opIdx + 1 < op.size()) {
            int a = calculate(opIdx + 1, num.get(opIdx + 1), num.get(opIdx + 2));
            DFS(opIdx + 2, calculate(opIdx, sum, a));
        }
    }

    private int calculate(int opIdx, int a, int b) {
        char c = op.get(opIdx);
        if(c == '+') return a + b;
        else if(c == '-') return a - b;
        else return a * b;
    }

    public static void main(String[] args) throws Exception {
        new Main16637().input(new FastReader());
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
