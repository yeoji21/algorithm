package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main15961 {
    /*
    초밥 종류 중복 가능
    임의의 한 위치에서 k(3000)개의 접시를 연속으로 먹으면 할인
    초밥 종류 쿠폰쓰면 해당 초밥 하나 무료로
    만약 쿠폰 종류 초밥이 없으면 만들어서 제공

    가능한 한 다양한 종류의 초밥을 먹으려 함
    k개 연속 + 초밥 쿠폰쓰면 k + 1개 가능

    초밥 수 N(300만), 초밥 가짓수 d(3000)
     */
    private int n, d, k, c;
    private int[] arr;
    private int[] checked;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        d = reader.nextInt();
        k = reader.nextInt();
        c = reader.nextInt();
        arr = new int[n];
        checked = new int[d + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextIntLine();
        }

        solution();
    }

    private void solution() {
        int left = 0, right = 0;
        int max = 0;
        int count = 1;
        checked[c]++;
        while(right < n + k - 1){
            if(checked[arr[right % n]] == 0){
                count++;
            }
            checked[arr[right % n]]++;

            max = Math.max(max, count);
            if(right - left + 1 == k){
                checked[arr[left]]--;
                if(checked[arr[left]] == 0) count--;
                left++;
            }
            right++;
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main15961().input(new FastReader());
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
