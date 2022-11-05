package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main10798 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] map = new char[5][15];
        int max = 0;

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            max = Math.max(max, line.length());
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int j = 0; j < max; j++) {
            for (int i = 0; i < 5; i++) {
                if(map[i][j] == '\0') continue;
                answer.append(map[i][j]);
            }
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main10798().solv();
    }
}
