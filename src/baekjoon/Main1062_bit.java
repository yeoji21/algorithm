package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1062_bit {
    private int N, K;
    private int mask;
    private int[] words;
    private int answer = 0;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        K = getIntToken(tokenizer);
        words = new int[N];

        for (int i = 0; i < N; i++) {
            int value = 0;
            for (char w : br.readLine().toCharArray()){
                value |= (1 << (w - 'a'));
            }
            words[i] = value;
        }


        if(K < 5) {
            System.out.println(answer);
            return;
        } else{
            mask |= (1 << ('a' - 'a'));
            mask |= (1 << ('n' - 'a'));
            mask |= (1 << ('t' - 'a'));
            mask |= (1 << ('i' - 'a'));
            mask |= (1 << ('c' - 'a'));
            combination(K - 5, 0, mask);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void combination(int level, int start, int mask) {
        if (level == 0) {
            int count = 0;
            for (int word : words) {
                if((word | mask) == mask) count++;
            }

            answer = Math.max(answer, count);
            return;
        }

        for (int i = start; i < 27; i++) {
            if ((mask & (1 << i)) == 0) {
                combination(level - 1, i + 1, (mask | (1 << i)));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main1062_bit().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
