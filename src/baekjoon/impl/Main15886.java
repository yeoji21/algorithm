package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main15886 {
    /*
    1xN 지도의 각 칸에는 E, W 중 한 문자가 쓰여져 있음
    E면 앞으로, W면 뒤로 이동
    이동을 시작하는 위치와 관계없이 선물을 주기 위해
    최소 몇 개의 칸 위에 선물을 놓으면 되는지
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        boolean[] present = new boolean[n + 1];
        char[] road = new char[n + 1];
        String s = reader.nextLine();
        for (int i = 0; i < s.length(); i++) {
            road[i + 1] = s.charAt(i);
        }
        solution(present, road);
    }

    private void solution(boolean[] present, char[] road) {
        int count = 0;
        for(int i = 1; i < road.length; i++){
            if(road[i] == 'W'){
                int temp = i;
                while(true){
                    if(temp > 0 && road[temp] == 'W') temp--;
                    else break;
                }
                if (!present[temp]) {
                    count++;
                    present[temp] = true;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main15886().input(new FastReader());
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
