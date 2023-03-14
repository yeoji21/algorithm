package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main16508 {
    private StringBuilder answer = new StringBuilder();
    private int min = Integer.MAX_VALUE;
    private int[] prices;
    private String[] title;
    private String t;
    private Map<Character, Integer> map = new HashMap<>();

    private void input(FastReader reader) throws Exception{
        t = reader.nextLine();
        int n = reader.nextIntLine();
        prices = new int[n];
        title = new String[n];
        for (int i = 0; i < n; i++) {
            prices[i] = reader.nextInt();
            title[i] = reader.next();
        }

        solution(0, new boolean[n]);

        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    private void solution(int start, boolean[] selected) {
        check(selected);
        if (start == selected.length) return;

        for (int i = start; i < selected.length; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            solution(i + 1, selected);
            selected[i] = false;
        }
    }

    private void check(boolean[] selected) {
        int sum = 0;

        map.clear();
        for (int i = 0; i < selected.length; i++) {
            if(!selected[i]) continue;
            sum += prices[i];
            for (char ch : title[i].toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        boolean check = true;
        for (int i = 0; i < t.length(); i++) {
            if(!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0){
                check = false;
                break;
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        if(check) min = Math.min(min, sum);
    }

    public static void main(String[] args) throws Exception {
        new Main16508().input(new FastReader());
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
