package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main16916 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String pattern = br.readLine();

        int[] table = makeTable(pattern);
        int idx = 0;
        for (int i = 0; i < target.length(); i++) {
            while(idx > 0 && target.charAt(i) != pattern.charAt(idx))
                idx = table[idx - 1];
            if(target.charAt(i) == pattern.charAt(idx)){
                if(idx == pattern.length() - 1){
                    System.out.println(1);
                    return;
                }
                idx++;
            }
        }
        System.out.println(0);
    }

    private int[] makeTable(String pattern) {
        int[] table = new int[pattern.length()];
        int idx = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while(idx > 0 && pattern.charAt(i) != pattern.charAt(idx))
                idx = table[idx - 1];
            if(pattern.charAt(i) == pattern.charAt(idx))
                table[i] = ++idx;
        }

        return table;
    }

    public static void main(String[] args) throws Exception {
        new Main16916().solv();
    }
}
