package baekjoon.backtracking;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main1174 {
    private int n;
    private Set<Long> set = new HashSet<>();
    private int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private void input(FastReader reader) throws Exception {
        n = reader.nextIntLine();
        if(n > 1023) {
            System.out.println(-1);
            return;
        }
        DFS(0, 0);
        List<Long> list = set.stream().sorted()
                .collect(Collectors.toList());
        System.out.println(list.get(n - 1));
    }

    private void DFS(int idx, long sum) {
        if (!set.contains(sum)) {
            set.add(sum);
        }
        if(idx >= arr.length) return;
        DFS(idx + 1, sum * 10 + arr[idx]);
        DFS(idx + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        new Main1174().input(new FastReader());
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
