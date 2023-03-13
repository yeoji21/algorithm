package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main1969 {
    int n, m;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextLine();
        }
        solution(arr);
    }

    private void solution(String[] arr) {
        //a c g t
        int[] count;
        StringBuilder result = new StringBuilder();
        int gap = 0;
        for(int i = 0; i < m; i++){
            count = new int[4];
            for(int j = 0; j < n; j++){
                char ch = arr[j].charAt(i);
                if(ch == 'A') count[0]++;
                else if(ch == 'C') count[1]++;
                else if(ch == 'G') count[2]++;
                else count[3]++;
            }

            int max = 0;
            int maxIdx = -1;
            for(int j = 0; j < 4; j++){
                if(count[j] > max){
                    gap += max;
                    max = count[j];
                    maxIdx = j;
                }else{
                    gap += count[j];
                }
            }
            if(maxIdx == 0) result.append('A');
            else if(maxIdx == 1) result.append('C');
            else if(maxIdx == 2) result.append('G');
            else result.append('T');
        }
        System.out.println(result.toString());
        System.out.println(gap);
    }

    public static void main(String[] args) throws Exception {
        new Main1969().input(new FastReader());
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
