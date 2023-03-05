package baekjoon;

import java.io.*;
import java.util.*;

public class Main16926 {
    /*
    반시계 방향으로 배열 돌리기
    */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = getIntToken(tokenizer);
        int m = getIntToken(tokenizer);
        int r = getIntToken(tokenizer);

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = getIntToken(tokenizer);
            }
        }
        solution(map, n, m, r);
    }

    void solution(int[][] map, int n, int m, int r){
        while(r-- > 0){
            rotate(map, 0, m - 1, 0, n - 1);
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                answer.append(map[i][j] + " ");
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }

    void rotate(int[][] map, int left, int right, int top, int bottom){
        if(left > right || top > bottom) return;

        int temp = map[top][left];
        for(int j = left; j < right; j++){
            map[top][j] = map[top][j + 1];
        }
        for(int i = top; i < bottom; i++){
            map[i][right] = map[i + 1][right];
        }
        for(int j = right; j >= left + 1; j--){
            map[bottom][j] = map[bottom][j - 1];
        }
        for(int i = bottom; i >= top + 1; i--){
            map[i][left] = map[i - 1][left];
        }

        if(top + 1 > bottom) map[top][left] = temp;
        else map[top + 1][left] = temp;

        rotate(map, left + 1, right - 1, top + 1, bottom - 1);
    }

    public static void main(String[] args) throws Exception {
        new Main16926().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
