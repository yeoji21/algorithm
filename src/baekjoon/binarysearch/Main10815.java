package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main10815 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        int[] cards = new int[n];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = reader.nextInt();
        }
        int m = reader.nextIntLine();
        int[] targets = new int[m];
        for (int i = 0; i < targets.length; i++) {
            targets[i] = reader.nextInt();
        }
        Arrays.sort(cards);
        solution(cards, targets);
        System.out.println(answer.toString());
    }

    private void solution(int[] cards, int[] targets) {
        for(int target : targets){
            if(find(cards, target)) answer.append("1");
            else answer.append("0");
            answer.append(" ");
        }
    }

    boolean find(int[] cards, int t){
        int start = 0;
        int end = cards.length;

        while(start < end){
            int mid = (start + end) / 2;
            if(cards[mid] == t) return true;
            if(cards[mid] > t){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Main10815().input(new FastReader());
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
