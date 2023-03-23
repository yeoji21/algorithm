package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main2110 {
    private int n, c;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        c = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        solution();
    }

    private void solution() {
        Arrays.sort(arr);
        int left = 0;
        int right = arr[arr.length - 1] - arr[0] + 1;
        while(left < right){
            int mid = (left + right) / 2;

            int count = 1;
            int house = arr[0];
            for(int i = 1; i < arr.length; i++){
                if(arr[i] - house >= mid){
                    count++;
                    house = arr[i];
                }
            }
            if(count >= c){
                left = mid + 1;
            }else{
                right = mid;
            }

        }
        System.out.println(right - 1);
    }

    public static void main(String[] args) throws Exception {
        new Main2110().input(new FastReader());
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
