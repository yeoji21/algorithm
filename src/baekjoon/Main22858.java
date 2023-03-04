package baekjoon;

import java.io.*;
import java.util.*;

public class Main22858 {
    /*
    숫자가 적혀있는 N개의 카드 P
    그리고 1부터 N까지 숫자가 하나씩 적힌 D
    카드섞기 : Di는 PDi 값을 i번째로 가지고 오는 것
    그니까 D에 적힌 숫자에 해당하는 인덱스(1부터 시작)에 해당하는 카드를 해당 위치로 옮김
    이렇게 K번 섞은 카드와 D의 정보를 알 때 원래 배치를 구하시오
    */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = getIntToken(tokenizer);
        int k = getIntToken(tokenizer);
        int[] cards = new int[n + 1];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++){
            cards[i] = getIntToken(tokenizer);
        }
        Map<Integer, Integer> map = new HashMap<>();
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++){
            map.put(getIntToken(tokenizer), i);
        }
        int[] temp;
        while(k-- > 0){
            temp = new int[n + 1];
            for(int i = 1; i < n + 1; i++){
                int idx = map.get(i);
                temp[i] = cards[idx];
            }
            cards = temp;
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 1; i < n + 1; i++){
            answer.append(cards[i]).append(" ");
        }
        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws Exception {
        new Main22858().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}

