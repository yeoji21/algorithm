package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main1283 {
    /*
    N개의 옵션마다 한 개 또는 여러 개의 단어로 설명이 있음
    차례대로 옵션의 단축키를 의미하는 대표 알파벳을 지정

    - 단어의 첫 글자가 이미 단축키로 지정되었는지 확인
    - 모든 단어의 첫 글자가 이미 지정되었으면 왼쪽부터 차례대로 단축키인지 검사
    - 어떤 것도 단축키로 할 수 없으면 그냥 놔두며? 대소문자 구분 x

     */
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        boolean[] check = new boolean[26];

        while (n-- > 0) {
            String s = reader.nextLine();
            solution(check, s);
        }
        System.out.println(answer.toString());
    }


    private void solution(boolean[] check, String s) {
        String[] words = s.split(" ");

        int idx = 0;
        for(String word : words){
            char ch = Character.toLowerCase(word.charAt(0));
            if(!check[ch - 'a']){
                check[ch - 'a'] = true;
                addShortCut(s, idx);
                return;
            }
            idx += word.length() + 1;
        }

        for(int i = 0; i < s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            if(ch == ' ') continue;
            if(!check[ch - 'a']){
                check[ch - 'a'] = true;
                addShortCut(s, i);
                return;
            }
        }
        addShortCut(s, -1);
    }

    void addShortCut(String s, int idx){
        if(idx == -1){
            answer.append(s).append("\n");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i == idx){
                sb.append("[");
                sb.append(s.charAt(i));
                sb.append("]");
            }else{
                sb.append(s.charAt(i));
            }
        }
        answer.append(sb.toString()).append("\n");
    }

    public static void main(String[] args) throws Exception {
        new Main1283().input(new FastReader());
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
