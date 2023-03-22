package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11663 {
    private StringBuilder answer = new StringBuilder();
    private int n, m;
    private int[] dots;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        dots = new int[n];
        for (int i = 0; i < n; i++) {
            dots[i] = reader.nextInt();
        }
        Arrays.sort(dots);

        for (int i = 0; i < m; i++) {
            int left = findLeftMost(reader.nextInt());
            int right = findRightMost(reader.nextInt());
            answer.append(right - left).append("\n");
        }
        System.out.println(answer.toString());
    }

    private int findLeftMost(int value) {
        int left = 0, right = n;
        while(left < right){
            int mid = (left + right) / 2;

            if(dots[mid] < value){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    private int findRightMost(int value) {
        int left = 0, right = n;
        while(left < right){
            int mid = (left + right) / 2;

            if(dots[mid] <= value){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) throws Exception {
        new Main11663().input(new FastReader());
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
