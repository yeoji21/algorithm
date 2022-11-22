package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main16943 {
    /*
    A의 숫자를 **섞어서** 만들 수 있는 수 중에서
    B보다 작으면서 가장 큰 수
    그런 수가 없으면 -1
     */
    private int[] numbers;
    private int A, B;
    private int answer = -1;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        A = getIntToken(tokenizer);
        numbers = new int[String.valueOf(A).length()];
        int temp = A;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = temp % 10;
            temp /= 10;
        }
        B = getIntToken(tokenizer);
        permutation(0, new boolean[numbers.length], 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void permutation(int level, boolean[] checked, int value) {
        if (level == numbers.length) {
            if(String.valueOf(value).length() != numbers.length) return;
            if(value > B) return;
            answer = Math.max(answer, value);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            permutation(level + 1, checked, value * 10 + numbers[i]);
            checked[i] = false;
        }
    }


    public static void main(String[] args) throws Exception {
        new Main16943().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
