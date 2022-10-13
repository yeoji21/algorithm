package programmers_level2;

public class 다음_큰_숫자 {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        while (++n <= 1_000_000) {
            if(Integer.bitCount(n) == count)
                return n;
        }
        return 0;
    }
}
