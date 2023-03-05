package baekjoon;

import java.io.*;
import java.util.*;

public class Main20207 {
    /*
    1일부터 165일까지 표시된 달력

    연속된 직사각형 모양 스케쥴을 하나로 취급
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = getIntLine(br);
        int[] count = new int[367];
        while (n-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int start = getIntToken(tokenizer);
            int end = getIntToken(tokenizer);
            for (int i = start; i <= end; i++) {
                count[i]++;
            }
        }
        int answer = 0;

        int width = 0;
        int maxCol = 0;
        for(int i = 0; i < count.length; i++){
            if(count[i] == 0){
                answer += width * maxCol;
                width = 0;
                maxCol = 0;
            }else{
                width++;
                maxCol = Math.max(maxCol, count[i]);
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main20207().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
