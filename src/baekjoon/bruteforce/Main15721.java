package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main15721 {
    private StringBuilder answer = new StringBuilder();
    private int a, t, flag;
    private int[] arr = new int[2];

    private void input(FastReader reader) throws Exception{
        a = reader.nextIntLine();
        t = reader.nextIntLine();
        flag = reader.nextIntLine();

        solution();
    }

    private void solution() {
        int round = 1;
        int count = 0;
        while(true){
            for(int i = 0; i < 4; i++){
                arr[i % 2]++;
                count++;
                if(arr[flag] == t){
                    find(count);
                    return;
                }
            }

            for(int i = 0; i < round + 1; i++){
                arr[0]++;
                count++;
                if(arr[flag] == t){
                    find(count);
                    return;
                }
            }
            for(int i = 0; i < round + 1; i++){
                arr[1]++;
                count++;
                if(arr[flag] == t){
                    find(count);
                    return;
                }
            }

            round++;
        }
    }

    void find(int count){
        System.out.println((count - 1) % a);
    }

    public static void main(String[] args) throws Exception {
        new Main15721().input(new FastReader());
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
