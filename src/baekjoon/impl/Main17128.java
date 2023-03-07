package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main17128 {
    /*
    소 N마리가 동그랗게 앉아있고, 각자 점수가 붙은 스티커가 있음
    N <= 200_000
     */
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        int total = 0;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 1;
            for (int j = i; j < i + 4; j++) {
                sum *= arr[j % n];
            }
            num[i] = sum;
            total += num[i];
        }

        for (int i = 0; i < m; i++) {
            int idx = reader.nextInt() - 1;
            arr[idx] *= -1;
            total = solution(arr, num, idx, total);
            answer.append(total).append("\n");
        }

        System.out.println(answer.toString());
    }

    private int solution(int[] arr, int[] num, int idx, int total) {
        for (int i = idx - 3; i <= idx; i++) {
            int sum = 1;
            for (int j = i; j < i + 4; j++) {
                sum *= arr[(j + arr.length) % arr.length];
            }
            total -= num[(i + arr.length) % arr.length];
            num[(i + arr.length) % arr.length] = sum;
            total += sum;
        }

        return total;
    }

    public static void main(String[] args) throws Exception {
        new Main17128().input(new FastReader());
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
