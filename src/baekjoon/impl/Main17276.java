package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main17276 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = getIntLine(br);
        StringBuilder answer = new StringBuilder();
        while(T -- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int n = getIntToken(tokenizer);
            int degree = getIntToken(tokenizer);
            if(degree < 0) degree = 360 + degree;
            int time = degree / 45;
            int[][] map = new int[n][n];
            for(int i = 0; i < n; i++){
                tokenizer = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = getIntToken(tokenizer);
                }
            }

            while(time-- > 0){
                int crossX = n - 1;
                int crossY = 0;
                for(int i = 0; i < n; i++){
                    swap(map, crossX - i, crossY + i, n / 2, i);
                }

                for(int i = 0; i < n; i++){
                    swap(map, crossX - i, crossY + i, i, i);
                }

                for(int i = 0; i < n; i++){
                    swap(map, crossX - i, crossY + i, i, n / 2);
                }

                for(int i = 0; i < n / 2; i++){
                    swap(map, crossX - i, crossY + i, crossY + i, crossX - i);
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    answer.append(map[i][j] + " ");
                }
                answer.append("\n");
            }
        }
        System.out.println(answer.toString());
    }

    void swap(int[][] map, int fx, int fy, int lx, int ly){
        int temp = map[fx][fy];
        map[fx][fy] = map[lx][ly];
        map[lx][ly] = temp;
    }

    public static void main(String[] args) throws Exception {
        new Main17276().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
