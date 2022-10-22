package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main16916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        int[] table = makeTable(P);
        int idx = 0;
        for (int i = 0; i < S.length(); i++) {
            while (idx > 0 && S.charAt(i) != P.charAt(idx)) {
                idx = table[idx - 1];
            }
            if (S.charAt(i) == P.charAt(idx)) {
                if(idx == P.length() - 1){
                    System.out.println("1");
                    return;
                }
                idx++;
            }
        }
        System.out.println("0");
    }

    private static int[] makeTable(String target) {
        int[] table = new int[target.length()];
        int idx = 0;

        for (int i = 1; i < target.length(); i++) {
            while (idx > 0 && target.charAt(i) != target.charAt(idx)) {
                idx = table[idx - 1];
            }
            if (target.charAt(i) == target.charAt(idx)) {
                table[i] = ++idx;
            }
        }
        return table;
    }
}
