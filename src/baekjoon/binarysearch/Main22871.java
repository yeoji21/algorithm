package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main22871 {
    private StringBuilder answer = new StringBuilder();
    /*
    숫자가 부여된 n개의 돌 (1-index)
    lower bound
     */
    private int[] arr;
    private boolean[] checked;
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        solution();
    }

    private void solution() {
        long right = (long) (arr.length - 1) * (1 + Math.abs(arr[0] - arr[arr.length - 1])) + 1;
        long left = 0;
        long ans = Integer.MAX_VALUE;
        while(left < right){
            long mid = (right - left) / 2 + left;
            checked = new boolean[arr.length];
            if(check(0, mid, checked)){
                ans = Math.min(ans, mid);
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    boolean check(int start, long k, boolean[] checked){
        if(start >= arr.length - 1){
            return true;
        }

        for(int i = start + 1; i < arr.length; i++){
            if(checked[i]) continue;
            long v = (long) (i - start) * (1 + Math.abs(arr[start] - arr[i]));
            if(v <= k){
                checked[i] = true;
                if(check(i, k, checked))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Main22871().input(new FastReader());
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
