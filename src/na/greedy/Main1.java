package na.greedy;

import java.util.*;

public class Main1 {
    static int[] coins = new int[]{500, 100, 50, 10};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        new Main1().solution(n);
    }

    public void solution(int n) {
        int result = 0;

        for (int i = 0; i < coins.length; i++) {
            while (n >= coins[i]) {
                n -= coins[i];
                result ++;
            }
        }
        System.out.println(result);
    }
}
