package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1051 {
    /*
    꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 **정사각형**
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int M = getIntToken(tokenizer);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) - '0';

            }
        }
        int answer = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int start = map[i][j];
                for (int k = j + 1; k < M; k++) {
                    if (map[i][k] == start) {
                        int gap = k - j;
                        if(i + gap < N && map[i + gap][j] == start && map[i+gap][k] == start)
                            answer = Math.max(answer, (gap + 1) * (gap + 1));
                    }
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main1051().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
