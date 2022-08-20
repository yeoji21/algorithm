package programmers_level2;

import java.math.BigInteger;

public class 멀쩡한_사각형 {
    public long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }

    public long solution2(int w, int h) {
        long result = 0;
        for (int i = 0; i < w; i++) {
            result += i * (long) h / w;
        }
        return result * 2;
    }
}
