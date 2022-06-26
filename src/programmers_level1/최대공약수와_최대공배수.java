package programmers_level1;

import java.math.BigInteger;

public class 최대공약수와_최대공배수 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = gcd(n, m);
        answer[0] = gcd;
        answer[1] = n * m / gcd;
        return answer;
    }

    public int[] solution2(int n, int m) {
        int[] answer = new int[2];
        int gcd = BigInteger.valueOf(n).gcd(BigInteger.valueOf(m)).intValue();
        answer[0] = gcd;
        answer[1] = n * m / gcd;
        return answer;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
