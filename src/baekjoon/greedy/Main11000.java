package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main11000 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        Schedule[] arr = new Schedule[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Schedule(reader.nextInt(), reader.nextInt());
        }

        solution(arr);
    }

    private void solution(Schedule[] arr) {
        Arrays.sort(arr, Comparator.comparing((Schedule s) -> s.start).thenComparing(s -> s.end));
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(arr[0].end);

        for (int i = 1; i < arr.length; i++) {
            if(q.peek() <= arr[i].start){
                q.poll();
            }
            q.add(arr[i].end);
            answer = Math.max(answer, q.size());
        }

        System.out.println(answer);
    }

    class Schedule{
        int start, end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main11000().input(new FastReader());
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
