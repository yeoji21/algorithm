package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main2961 {
    private StringBuilder answer = new StringBuilder();
    /*
    N개의 재료
    신맛은 곱, 쓴맛은 합
    신맛과 쓴맛의 차이를 작게 만들기
    재료 하나 이상 사용
     */
    private int n, min = Integer.MAX_VALUE;
    private int[][] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = reader.nextInt();
            arr[i][1] = reader.nextInt();
        }

        solution(0, 0, new boolean[n]);
        System.out.println(min);
    }

    private void solution(int depth, int start, boolean[] checked) {
        if(depth > 0){
            check(checked);
        }
        if(depth > n) return;

        for(int i = start; i < n; i++){
            if(checked[i]) continue;
            checked[i] = true;
            solution(depth + 1, i + 1, checked);
            checked[i] = false;
        }
    }

    void check(boolean[] checked){
        int sour = 1;
        int bit = 0;
        for(int i = 0; i < n; i++){
            if(!checked[i]) continue;
            sour *= arr[i][0];
            bit += arr[i][1];
        }

        min = Math.min(min, Math.abs(sour - bit));
    }

    public static void main(String[] args) throws Exception {
        new Main2961().input(new FastReader());
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
