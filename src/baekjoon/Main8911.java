package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main8911 {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String commands = br.readLine();
            answer.append(moveTurtle(commands)).append("\n");
        }
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int moveTurtle(String commands) {
        int d = 0;
        int x = 0;
        int y = 0;
        int maxW = 0, minW = 0, maxH = 0, minH = 0;

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'F') {
                x = x + dx[d];
                y = y + dy[d];
            } else if (command == 'B') {
                x = x + dx[(d + 2) % 4];
                y = y + dy[(d + 2) % 4];
            } else if (command == 'L') {
                d = (d + 3) % 4;
            } else{
                d = (d + 1) % 4;
            }

            maxW = Math.max(maxW, x);
            minW = Math.min(minW, x);
            maxH = Math.max(maxH, y);
            minH = Math.min(minH, y);
        }
        if(maxW - minW == 0 || maxH - minH == 0)
            return 0;
        return (Math.abs(maxW) + Math.abs(minW)) * (Math.abs(maxH) + Math.abs(minH));
    }

    public static void main(String[] args) throws Exception {
        new Main8911().solv();
    }
}
