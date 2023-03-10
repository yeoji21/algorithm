package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main20115 {
    private StringBuilder answer = new StringBuilder();
    /*
    - 서로 다른 두 가지 고름
    - 한쪽에 붓는데, 붓다가 절반을 흘림
    - 부은 건 버리고, 하나가 남을 때까지 반복
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextLong();
        }
        solution(arr);
    }

    private void solution(long[] arr) {
        Arrays.sort(arr);
        double sum = arr[arr.length - 1];

        for(int i = 0; i < arr.length -1; i++){
            sum += (double)(arr[i]) / 2;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main20115().input(new FastReader());
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
