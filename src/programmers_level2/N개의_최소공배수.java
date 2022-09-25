package programmers_level2;

import java.math.BigInteger;

public class N개의_최소공배수 {
    public int solution(int[] arr) {
        int asnwer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            BigInteger gcd = BigInteger.valueOf(asnwer).gcd(BigInteger.valueOf(arr[i]));
            asnwer = asnwer * arr[i] / gcd.intValue();
        }
        return asnwer;
    }

    public int solution2(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }
        return lcm;
    }

    private int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

}
