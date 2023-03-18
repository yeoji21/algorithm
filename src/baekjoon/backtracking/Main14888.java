package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main14888 {
    private StringBuilder answer = new StringBuilder();
    /*
    +, -, *, /
    나눗셈은 몫만 취함
    음수를 양수로 나눌 때는 양수로 바꾸고 몫을 음수로
     */
    private int n;
    private int[] arr;
    private int[] op = new int[4];
    private int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            op[i] = reader.nextInt();
        }

        solution(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private void solution(int depth, int sum) {
        if(depth == n - 1){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(op[i] == 0) continue;
            op[i]--;
            solution(depth + 1, calculate(i, sum, arr[depth + 1]));
            op[i]++;
        }
    }

    private int calculate(int op, int a, int b) {
        if(op == 0){
            return a + b;
        }else if(op == 1){
            return a - b;
        }else if(op == 2){
            return a * b;
        }else{
            if(a < 0){
                a *= -1;
                return a / b * -1;
            }
            return a / b;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main14888().input(new FastReader());
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
