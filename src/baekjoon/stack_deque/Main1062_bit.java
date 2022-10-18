package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1062_bit {
    private static int answer = 0;
    private static int mask;
    private static int[] words;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);

        words = new int[N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (char ch : line.toCharArray()) {
                words[i] |= 1 << (ch - 'a');
            }
        }

        if(K < 5) {
            System.out.println("0");
            return;
        } else if(K == 26) {
            System.out.println(N);
            return;
        }
        mask = 0;

        mask |= 1 << ('a' - 'a');
        mask |= 1 << ('n' - 'a');
        mask |= 1 << ('t' - 'a');
        mask |= 1 << ('c' - 'a');
        mask |= 1 << ('i' - 'a');

        combination(0, K - 5, mask);
        System.out.println(answer);
    }

    private static void combination(int start, int level, int mask) {
        if (level == 0) {
            int count = 0;
            for (int word : words) {
                if((word | mask) == mask) count++;
            }
            answer = Math.max(answer, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if ((mask & (1 << i)) == 0) {
                combination(i + 1, level - 1, mask | (1 << i));
            }
        }
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
