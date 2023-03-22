package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main2512 {
    private StringBuilder answer = new StringBuilder();
    /*
    국가 예산을 넘지 않으면서 최대로 배정
    배정된 예산들 중 최댓값 리턴
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
            max = Math.max(max, arr[i]);
        }
        int target = reader.nextIntLine();
        int left = target / arr.length;
        int right = max + 1;
        solution(arr, left, right, target);
    }

    private void solution(int[] arr, int left, int right, int target) {
        int ans = 0;
        while(left < right){
            int sum = 0;
            int mid = (left + right) / 2;
            for(int n : arr){
                if(n > mid) sum += mid;
                else sum += n;
            }
            if(sum == target){
                ans = mid;
                break;
            }
            if(sum < target){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main2512().input(new FastReader());
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
