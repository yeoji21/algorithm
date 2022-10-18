package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1062 {
    private static int answer = 0;
    private static boolean[] checked = new boolean[26];
    private static String[] words;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);

        words = new String[N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            line = line.substring(4, line.length() - 4);
            words[i] = line;
        }

        if(K < 5) {
            System.out.println("0");
            return;
        } else if(K == 26) {
            System.out.println(N);
            return;
        }

        checked['a' - 'a'] = true;
        checked['n' - 'a'] = true;
        checked['t' - 'a'] = true;
        checked['i' - 'a'] = true;
        checked['c' - 'a'] = true;

        combination(0, K - 5);
        System.out.println(answer);
    }

    private static void combination(int start, int level) {
        if (level == 0) {
            int count = 0;

            for (int i = 0; i < words.length; i++) {
                boolean correct = true;
                for (char ch : words[i].toCharArray()) {
                    if(!checked[ch - 'a']){
                        correct = false;
                        break;
                    }
                }
                if(correct) count++;
            }
            answer = Math.max(answer, count);
            return;
        }

        for (int i = start; i < checked.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            combination(i + 1, level - 1);
            checked[i] = false;
        }
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
