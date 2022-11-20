package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1527 {
    private int start, end;
    private int answer = 0;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        start = getIntToken(tokenizer);
        end = getIntToken(tokenizer);
        answer = 0;

        DFS(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void DFS(long num) {
        if(num > end) return;
        if(num >= start) answer++;

        DFS(num * 10 + 4);
        DFS(num * 10 + 7);
    }

    public static void main(String[] args) throws Exception {
        new Main1527().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
