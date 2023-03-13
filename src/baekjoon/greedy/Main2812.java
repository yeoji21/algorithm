package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main2812 {
    private StringBuilder answer = new StringBuilder();
    private int n, k;
    private String num;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        k = reader.nextInt();
        num = reader.nextLine();
        solution();
    }

    private void solution() {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for(char ch : num.toCharArray()){
            int value = ch - '0';
            while(count < k && !stack.isEmpty() && value > stack.peek()){
                stack.pop();
                count++;
            }
            stack.push(value);
        }
        for (int i = 0; i < n - k; i++) {
            answer.append(stack.getLast());
            stack.removeLast();
        }
        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws Exception {
        new Main2812().input(new FastReader());
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
