package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main21758 {
    /*
    좌우대칭
    두 장소에 벌을 한 마리씩 두고 한 곳에는 벌통을 둔다
    벌이 출발한 곳은 꿀 딸 수 없고 벌통에서는 딸 수 있음

    https://velog.io/@silver_star/백준-21758-꿀-따기-Greedy
     */
    private int[] honey, toRight, toLeft;
    private int maxSum, answer = 0;
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        honey = new int[n];
        for (int i = 0; i < honey.length; i++) {
            honey[i] = reader.nextInt();
        }
        toRight = new int[n];
        toLeft = new int[n];

        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += honey[i];
            toRight[i] = temp;
        }
        temp = 0;
        for (int i = n - 1; i >= 0; i--) {
            temp += honey[i];
            toLeft[i] = temp;
        }
        maxSum = toRight[n - 1];

        rightBucket();
        leftBucket();
        centerBucket();

        System.out.println(answer);
    }

    private void centerBucket() {
        int sum = 0;
        int max = 0;
        for (int i = 1; i < honey.length - 1; i++) {
            sum += honey[i];
            max = Math.max(max, honey[i]);
        }
        answer = Math.max(answer, sum + max);

//        for (int i = 1; i < honey.length - 1; i++) {
//            int leftBee = toRight[i] - honey[0];
//            int rightBee = toLeft[i] - honey[honey.length - 1];
//            answer = Math.max(answer, leftBee + rightBee);
//        }
    }

    private void leftBucket() {
        for (int i = honey.length - 2; i >= 1; i--) {
            int staticBee = maxSum - honey[honey.length - 1] - honey[i];
            int activeBee = maxSum - toLeft[i];
            answer = Math.max(answer, staticBee + activeBee);
        }
    }

    private void rightBucket() {
        for (int i = 1; i < honey.length - 1; i++) {
            int staticBee = maxSum - honey[0] - honey[i];
            int activeBee = maxSum - toRight[i];
            answer = Math.max(answer, staticBee + activeBee);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main21758().input(new FastReader());
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
