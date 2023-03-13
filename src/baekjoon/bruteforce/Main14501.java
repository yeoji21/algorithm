package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main14501 {
    private StringBuilder answer = new StringBuilder();

    private int n;
    private Schedule[] arr;
    private int max = 0;
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        arr = new Schedule[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Schedule(reader.nextInt(), reader.nextInt());
        }
        solution(0, 0, new boolean[n]);
        System.out.println(max);
    }

    private void solution(int start, int value, boolean[] checked) {
        max = Math.max(max, value);
        if(start >= arr.length) return;

        for(int i = start; i < arr.length; i++){
            if(checked[i]) continue;
            int last = i + arr[i].period;
            if(last > arr.length) continue;

            for(int j = i; j < last; j++){
                checked[j] = true;
            }
            solution(i + 1, value + arr[i].pay, checked);
            for(int j = i; j < last; j++){
                checked[j] = false;
            }
        }
    }

    class Schedule{
        int period, pay;

        public Schedule(int period, int pay) {
            this.period = period;
            this.pay = pay;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main14501().input(new FastReader());
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
