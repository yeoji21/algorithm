package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main13975 {
    private StringBuilder answer = new StringBuilder();
    /*
    각 챕터를 서로 다른 파일에 저장
    소설을 다 쓰면 모든 챕터를 합쳐서 하나의 파일로 만듦
    두 파일을 합쳐서 하나의 임시 파일을 만들고
    임시파일이나 원래 파일 두 개를 합쳐가면서 하나를 만듦
    두 개의 파일을 합칠 때 필요한 비용이 두 파일 크기의 합일 때
    최종적인 하나의 파일을 만드는데 필요한 비용의 합
     */
    private void input(FastReader reader) throws Exception{
        int t = reader.nextIntLine();
        PriorityQueue<Long> q = new PriorityQueue<>();
        while (t-- > 0) {
            q.clear();
            int n = reader.nextIntLine();
            for (int i = 0; i < n; i++) {
                q.add(reader.nextLong());
            }
            long sum = 0;
            n--;
            while (n-- > 0) {
                long temp = q.poll() + q.poll();
                sum += temp;
                q.add(temp);
            }
            answer.append(sum).append("\n");
        }
        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws Exception {
        new Main13975().input(new FastReader());
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
