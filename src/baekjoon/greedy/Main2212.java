package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2212 {
    private StringBuilder answer = new StringBuilder();
    /*
    n개의 센서 설치
    센서의 자료를 수집할 집중국 최대 k개 세울 수 있음

     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        int k = reader.nextIntLine();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        solution(arr, k);
    }

    private void solution(int[] arr, int k) {
        Arrays.sort(arr);
        int[] gap = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            gap[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(gap);
        int result = 0;
        for (int i = 0; i < arr.length - k; i++) {
            result += gap[i];
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main2212().input(new FastReader());
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
