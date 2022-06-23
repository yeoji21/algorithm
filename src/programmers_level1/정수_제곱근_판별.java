package programmers_level1;

import java.math.BigInteger;

public class 정수_제곱근_판별 {
    public long solution(long n) {
        BigInteger bigInteger = new BigInteger(String.valueOf(n));
        BigInteger processed = bigInteger.sqrt().pow(2);
        if(bigInteger.equals(processed))
            return Long.parseLong(bigInteger.sqrt().add(BigInteger.ONE).pow(2).toString());
        else
            return -1;
    }
}
