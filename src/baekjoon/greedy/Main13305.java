package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main13305 {
    private StringBuilder answer = new StringBuilder();
    /*
    n개의 수평 상 도시
    기름통 무제한
    1키로마다 기름 1리터 사용
    도시마다 리터당 기름값 다름
    제일 싸게 이동하는 비용
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        int[] distance = new int[n - 1];
        int[] city = new int[n];
        long totalDistance = 0;
        for (int i = 0; i < n - 1; i++) {
            distance[i] = reader.nextInt();
            totalDistance += distance[i];
        }
        for (int i = 0; i < n; i++) {
            city[i] = reader.nextInt();
        }

        solution(distance, city, totalDistance);
    }

    private void solution(int[] distance, int[] city, long totalDistance) {
        long price = city[0] * totalDistance;
        int min = city[0];
        totalDistance -= distance[0];

        for(int i = 1; i < distance.length; i++){
            if(city[i] < min){
                price -= (min - city[i]) * totalDistance;
                min = city[i];
            }
            totalDistance -= distance[i];
        }

        System.out.println(price);
    }

    public static void main(String[] args) throws Exception {
        new Main13305().input(new FastReader());
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
