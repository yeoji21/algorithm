package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main20300 {
    private StringBuilder answer = new StringBuilder();
    /*
    한번 PT에 운동기구 두 개까지만
    N개의 기구 중 사용해보지 않은 것들 선택 (되도록 2개 선택)
    PT 한 번 받을 때 근손실이 M을 넘지 않도록 하고 싶은데, 이때 M의 최솟값
    -> 2개씩 나눴을 때 합이 가장 작아지는 경우
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextLong();
        }
        solution(arr);
    }

    private void solution(long[] arr) {
        int left = 0, right;
        Arrays.sort(arr);

        long max = 0;
        if(arr.length % 2 == 1){
            right = arr.length - 2;
            max = arr[arr.length - 1];
        }else{
            right = arr.length - 1;
        }

        while(left < right){
            max = Math.max(max, arr[left++] + arr[right--]);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main20300().input(new FastReader());
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
