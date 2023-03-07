package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main5766 {
    /*
    랭킹에 선수 이름이 오를 때마다 1점씩 추가
    2등이 누구인지
    n : 행
    m : 열
    2등이 여러 명이면 오름차순으로 정렬
     */
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer>[] count;
    StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        while (true) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            if(n == 0 && m == 0) break;
            map.clear();
            count = new ArrayList[n * m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int key = reader.nextInt();
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            solution();
        }

        System.out.println(answer.toString());
    }

    private void solution() {
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(count[entry.getValue()] == null){
                count[entry.getValue()] = new ArrayList<>();
            }
            count[entry.getValue()].add(entry.getKey());
            max = Math.max(max, entry.getValue());
        }

        for(int i = max - 1; i >= 0; i--){
            if(count[i] != null){
                Collections.sort(count[i]);
                for(int j = 0; j < count[i].size(); j++){
                    answer.append(count[i].get(j)).append(" ");
                }
                answer.append("\n");
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main5766().input(new FastReader());
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