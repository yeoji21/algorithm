package programmers_level2;

import java.math.BigInteger;

public class N개의_최소공배수 {
    public static void main(String[] args) {
        int solution = solution(new int[]{2, 6, 8, 14});
//        int solution = solution2(new int[]{1, 2, 3});
        System.out.println(solution);
    }


    public static int solution(int[] arr) {
        int sum = arr[0];
        BigInteger lcm = BigInteger.valueOf(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm.gcd(BigInteger.valueOf(arr[i]));
            sum = sum * arr[i] / lcm.intValue();
            lcm = BigInteger.valueOf(sum);
        }
        return sum;
    }

    public static int solution2(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }
        return lcm;
    }

    private static int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    private static int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

}
