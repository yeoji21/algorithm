package programmers_level2;

public class 예상_대진표 {
    public int solution(int n, int a, int b) {
        int round = 1;
        if(isMatch(a, b))
            return round;

        while (!isMatch(a, b)) {
            round++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return round;
    }

    private boolean isMatch(int a, int b) {
        return Math.abs(a - b) == 1 && Math.min(a, b) % 2 == 1;
    }
}
