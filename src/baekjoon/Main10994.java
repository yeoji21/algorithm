package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10994 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = getIntLine(br);
        int n = 1 + (num - 1) * 4;
        boolean[][] map = new boolean[n][n];
        drawStar(map, 0, n, 0, n);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]) answer.append("*");
                else answer.append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }

    private void drawStar(boolean[][] map, int left, int right, int top, int bottom) {
        if(left > right || top > bottom) return;
        for (int i = left; i < right; i++) {
            map[i][top] = true;
            map[i][bottom - 1] = true;
        }
        for (int j = top; j < bottom; j++) {
            map[left][j] = true;
            map[right - 1][j] = true;
        }
        drawStar(map, left + 2, right - 2, top + 2, bottom - 2);
    }

    public static void main(String[] args) throws Exception {
        new Main10994().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}