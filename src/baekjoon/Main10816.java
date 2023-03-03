package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {
    /*
    N개의 카드 중에서 M개의 카드들이 각각 몇 장씩 있는지
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = getIntToken(tokenizer);
        }
        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = getIntToken(tokenizer);
        }

        solution(cards, targets);
    }

    void solution(int[] cards, int[] targets) {
        Arrays.sort(cards);
        StringBuilder answer = new StringBuilder();
        for(int target : targets){
            int lower = findLowerBound(target, cards);
            int upper = findUpperBound(target, cards);
            answer.append(upper - lower).append(" ");
        }
        answer.append("\n");
        System.out.println(answer);
    }

    int findLowerBound(int target, int[] cards) {
        int left = 0, right = cards.length;

        while(left < right){
            int mid = (left + right) / 2;
            if(cards[mid] >= target) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    int findUpperBound(int target, int[] cards) {
        int left = 0, right = cards.length;

        while(left < right){
            int mid = (left + right) / 2;
            if(cards[mid] <= target) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    public static void main(String[] args) throws Exception {
        new Main10816().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
