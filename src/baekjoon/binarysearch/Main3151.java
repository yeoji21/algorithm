package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main3151 {
    private StringBuilder answer = new StringBuilder();
    /*
    3명으로 구성된 팀
    코딩 실력(-1만 ~ 1만)
    3명의 코딩 실력의 합이 0이 되는 경우의 수
    팀을 얼마나 많이 만들 수 있는지
     */
    private int n;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        solution();
    }

    private void solution() {
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int key = -(arr[i] + arr[j]);
                int l = lowerBound(key, j + 1, n);
                if(l == n || arr[l] != key) continue;
                int u = upperBound(key, j + 1, n);
                count += u - l;
            }
        }

        System.out.println(count);
    }

    private int lowerBound(int key, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }

    private int upperBound(int key, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= key) {
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws Exception {
        new Main3151().input(new FastReader());
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
