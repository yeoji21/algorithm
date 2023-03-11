package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main1931 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        Schedule[] schedules = new Schedule[n];
        for (int i = 0; i < n; i++) {
            schedules[i] = new Schedule(reader.nextInt(), reader.nextInt());
        }

        solution(schedules);
    }

    private void solution(Schedule[] schedules) {
        Arrays.sort(schedules, Comparator.comparing((Schedule s) -> s.end).thenComparing(s -> s.start));
        int count = 0;
        int time = 0;
        for(int i = 0; i < schedules.length; i++){
            if(time <= schedules[i].start){
                count++;
                time = schedules[i].end;
            }
        }
        System.out.println(count);
    }

    class Schedule{
        int start, end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main1931().input(new FastReader());
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
