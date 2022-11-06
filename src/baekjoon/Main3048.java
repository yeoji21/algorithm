package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main3048 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int first = getIntToken(tokenizer);
        int second = getIntToken(tokenizer);
        int[] order = new int[first + second];
        for (int i = 0; i < order.length; i++) {
            if(i < first)
                order[i] = 1;
            else order[i] = 2;
        }
        String firstTeam = br.readLine();
        String secondTeam = br.readLine();
        int times = Integer.parseInt(br.readLine());

        for (int t = 0; t < times; t++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < order.length; i++) {
                if (order[i] == 1 && i + 1 < order.length && order[i+1] == 2) {
                    set.add(i);
                }
                else if(order[i] == 2 && i - 1 > 0 && order[i - 1] == 1){
                    set.add(i - 1);
                }
            }
            for (int toSwap : set) {
                swap(order, toSwap, toSwap + 1);
            }
        }

        int fIdx = 0;
        int sIdx = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < order.length; i++) {
            if(order[i] == 1) answer.append(firstTeam.charAt(first - 1 - fIdx++));
            else answer.append(secondTeam.charAt(sIdx++));
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private void swap(int[] order, int a, int b) {
        int temp = order[a];
        order[a] = order[b];
        order[b] = temp;
    }

    public static void main(String[] args) throws Exception {
        new Main3048().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}