package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = getIntToken(st);
        int K = getIntToken(st);

        Item[] items = new Item[N];
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(getIntToken(st), getIntToken(st));
        }

        for (int i = 0; i < items.length; i++) {
            for (int j = dp.length - 1; j >= items[i].weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - items[i].weight] + items[i].value);
            }
        }

        System.out.println(dp[K]);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static class Item{
        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
