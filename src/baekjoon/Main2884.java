package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2884 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int hour = getIntToken(tokenizer);
        int minute = getIntToken(tokenizer);
        StringBuilder answer = new StringBuilder();
        if(minute >= 45){
            answer.append(hour).append(" ").append(minute - 45);
        }else{
            int remain = 45 - minute;
            answer.append(hour - 1 == -1 ? 23 : hour - 1).append(" ").append(60 - remain);
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main2884().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
