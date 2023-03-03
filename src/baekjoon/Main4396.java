package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4396 {
    /*
    NxN 격자에 M개의 지뢰
    지뢰 건드리면 패배
    지뢰 아닌 곳 찍으면 상하좌우대각선 8개 중 지뢰가 몇개있는지 알려줌

    지뢰가 있는 칸이 열렸다면 지뢰가 있는 모든 칸이 별표로 표시되어야 함
     */
    private int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    private int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = getIntLine(br);
        boolean[][] boom = new boolean[n][n];
        char[][] map = new char[n][n];
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                if(line.charAt(j) == '*') boom[i][j] = true;
            }
        }
        boolean fail = false;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                if(boom[i][j] && line.charAt(j) != '.') fail = true;
                map[i][j] = line.charAt(j) == '.' ? '.' : findBooms(boom, i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(fail && boom[i][j]) answer.append("*");
                else answer.append(map[i][j]);
            }
            answer.append("\n");
        }

        System.out.println(answer.toString());
    }

    private char findBooms(boolean[][] boom, int i, int j) {
        int n = boom.length;
        int count = 0;
        for (int d = 0; d < 8; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if(nx >= n || nx < 0 || ny >= n || ny < 0) continue;
            if(boom[nx][ny]) count++;
        }
        return (char)(count + '0');
    }

    public static void main(String[] args) throws Exception {
        new Main4396().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
