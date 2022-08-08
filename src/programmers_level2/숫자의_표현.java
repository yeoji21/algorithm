package programmers_level2;

public class 숫자의_표현 {
    public int solution(int n) {
        int count = 0;

        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = i; j < n + 1; j++) {
                sum += j;
                if (sum == n) {
                    count++;
                    break;
                }
                else if (sum > n)
                    break;
            }
        }

        return count;
    }
}
