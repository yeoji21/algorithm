package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main1316 {
    /*
    같은 문자는 붙어서 나오는 단어
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = getIntLine(br);
        int answer = 0;
        boolean[] checked = new boolean[26];
        while (n-- > 0) {
            if(isGroupWord(br.readLine(), checked)) answer++;
        }
        System.out.println(answer);
    }

    private boolean isGroupWord(String s, boolean[] checked) {
        int i = 0;
        checked = new boolean[26];
        while(i < s.length()){
            char ch = s.charAt(i);
            if(checked[ch - 'a']) return false;
            checked[ch - 'a'] = true;
            while(i < s.length() && s.charAt(i) == ch){
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main1316().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
