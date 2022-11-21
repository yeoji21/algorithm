package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1107 {
    private boolean[] broken = new boolean[10];

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int channel = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if(n > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                broken[getIntToken(tokenizer)] = true;
            }
        }
        int approximation = Math.abs(100 - channel);

        for (int num = 0; num < 999_999 + 1; num++) {
            int value = num;
            boolean check = true;

            while (true) {
                if (broken[value % 10]) {
                    check = false;
                    break;
                }
                value /= 10;
                if(value == 0) break;
            }
            if (!check) continue;
            int gap = Math.abs(num - channel) + String.valueOf(num).length();
            if(approximation > gap) approximation = gap;
        }

        bw.write(approximation + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main1107().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
