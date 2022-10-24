package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main2293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);
        int[] coins = new int[N];
        int[] dp = new int[K + 1];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K + 1; j++) {
                if(j < coins[i]) continue;
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[K]);
    }

    private static int K;
    private static int[] coins;
    private static Set<String> set = new HashSet<>();

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        K = getIntToken(tokenizer);
        coins = new int[N];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        combination(new boolean[N], 0, 0);
        System.out.println(set.size());
    }

    private static void combination(boolean[] checked, int start, int level) {
        if (level > checked.length) {
            return;
        }
        getMoney(new int[checked.length], checked.clone(), 0, 0);

        for (int i = start; i < checked.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            combination(checked, i + 1, level + 1);
            checked[i] = false;
        }
    }

    private static void getMoney(int[] selected, boolean[] checked, int start, int sum) {
        if (sum >= K) {
            if (sum == K) {
                String value = Arrays.stream(selected)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining());
                set.add(value);
            }
            return;
        }
        for (int i = start; i < checked.length; i++) {
            if(checked[i]){
                selected[i]++;
                getMoney(selected, checked, i, sum + coins[i]);
                selected[i]--;
            }
        }
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
