package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main14719 {
    /*
    고이는 빗물의 총량
    HxW
    고이지 않으면 0
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int h = getIntToken(tokenizer);
        int w = getIntToken(tokenizer);
        tokenizer = new StringTokenizer(br.readLine());
        int[] blocks = new int[w];
        for (int i = 0; i < w; i++) {
            blocks[i] = getIntToken(tokenizer);
        }
        solution(blocks, h, w);
    }

    private void solution(int[] blocks, int h, int w) {
        int answer = 0;
        for(int i = 1; i < w - 1; i++){
            int now = blocks[i];
            int left = 0;
            int right = 0;
            for(int j = i - 1; j >= 0; j--){
                left = Math.max(left, blocks[j]);
            }
            for(int j = i + 1; j < w; j++){
                right = Math.max(right, blocks[j]);
            }
            if(Math.min(left, right) > now){
                answer += Math.min(left, right) - now;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main14719().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
