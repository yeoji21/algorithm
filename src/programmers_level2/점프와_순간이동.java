package programmers_level2;

public class 점프와_순간이동 {
    public int solution(int n) {
        int result = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                result++;
            }
        }

        return result;
    }
}
