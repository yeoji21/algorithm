package programmers_level1;

public class 자릿수_더하기 {
    public int solution(int n) {
        int sum = 0;

        while (n >= 10) {
            sum += n % 10;
            n = n / 10;
        }

        sum += n;

        return sum;
    }
}
