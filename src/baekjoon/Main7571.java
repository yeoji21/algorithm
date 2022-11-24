package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main7571 {
    private int N, M;
    private int[] rows;
    private int[] columns;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        rows = new int[M];
        columns = new int[M];
        int answer = 0;

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = getIntToken(tokenizer);
            int y = getIntToken(tokenizer);
            rows[i] = x;
            columns[i] = y;
        }

        Arrays.sort(rows);
        Arrays.sort(columns);

        int mx = rows[M / 2];
        int my = columns[M / 2];

        for (int i = 0; i < M; i++) {
            answer += Math.abs(rows[i] - mx) + Math.abs(columns[i] - my);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main7571().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
