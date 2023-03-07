package baekjoon.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main16719 {
    /*
    아직 보여주지 않은 문자 중 추가했을 때의 문자열이 사전 순으로 가장 앞에 오도록 하는 문자

     */
    private StringBuilder answer = new StringBuilder();
    private boolean[] checked;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        checked = new boolean[s.length()];
        solution(s,0, s.length() - 1);
        System.out.println(answer.toString());
    }

    private void solution(String s, int left, int right) {
        if(left > right) return;
        int idx = left;
        for(int i = left; i <= right; i++){
            if(s.charAt(i) < s.charAt(idx)){
                idx = i;
            }
        }
        checked[idx] = true;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(checked[i]) sb.append(s.charAt(i));
        }
        answer.append(sb.toString()).append("\n");
        solution(s, idx + 1, right);
        solution(s, left, idx - 1);
    }

    public static void main(String[] args) throws Exception {
        new Main16719().solv();
    }
}
