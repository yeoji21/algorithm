package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main1477 {
    private StringBuilder answer = new StringBuilder();
    /*
    n개의 휴게소, 시작으로부터 얼만큼 떨어져 있는지 주어짐
    m개의 휴게소 더 세우고자 함
    휴게소가 없는 구간의 최댓값을 최소로
    lower bound
     */
    private int n, m, l;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        l = reader.nextInt();
        arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = reader.nextInt();
        }
        arr[0] = 0;
        arr[n + 1] = l;
        solution();
    }

    private void solution() {
        int left = 1, right = l;
        Arrays.sort(arr);

        while(left < right){
            int mid = (left + right) / 2;
            int count = 0;
            for(int i = 1; i < n + 2; i++){
                count += (arr[i] - arr[i - 1] - 1) / mid;
            }

            if(count <= m){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(right);
    }

    public static void main(String[] args) throws Exception {
        new Main1477().input(new FastReader());
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
