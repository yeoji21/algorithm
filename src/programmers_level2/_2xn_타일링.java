package programmers_level2;

public class _2xn_타일링 {
    public int solution(int n) {
        int result = 1;
        int a = 1;
        int b = 1;

        for (int i = 1; i < n; i++) {
            result = (a + b) % 1000000007;
            a = b;
            b = result;
        }

        return result;
    }
}
