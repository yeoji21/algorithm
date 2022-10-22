package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1786 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();

        int count = 0;
        StringBuilder answer = new StringBuilder();
        int[] table = getPatternTable(P);
        int idx = 0;
        for (int i = 0; i < T.length(); i++) {
            while(idx > 0 && T.charAt(i) != P.charAt(idx)){
                idx = table[idx - 1];
            }
            if (T.charAt(i) == P.charAt(idx)) {
                if (idx == P.length() - 1) {
                    count++;
                    answer.append(i - idx + 1).append(" ");
                    idx = table[idx];
                } else idx++;
            }
        }

        answer.insert(0, count + "\n");
        System.out.println(answer.toString());
    }

    private static int[] getPatternTable(String pattern) {
        int[] table = new int[pattern.length()];
        int idx = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(idx)){
                table[i] = ++idx;
            }
        }
        return table;
    }
}
