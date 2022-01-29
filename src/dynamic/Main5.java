package dynamic;

import java.util.*;

public class Main5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();

        int targetMoney = sc.nextInt();
        int[] money = new int[targetMoney + 1];
        for (int i = 1; i < money.length; i++) money[i] = Integer.MAX_VALUE;

        new Main5().solution(coins, money);
    }

    public void solution(int[] coins, int[] money) {

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < money.length; j++) {
                money[j] = Math.min(money[j - coins[i]]+1, money[j]);
            }
        }

//        Arrays.stream(money).forEach(x -> System.out.print(x + " "));
        System.out.println(money[money.length-1]);
    }
}
