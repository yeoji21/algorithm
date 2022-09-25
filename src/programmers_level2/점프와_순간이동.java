package programmers_level2;

public class 점프와_순간이동 {
    public int solution(int n) {
        int answer = 0;

        while(n > 0) {
            if (n % 2 == 1) {
                answer++;
                n--;
            }
            n /= 2;
        }

        return answer;
    }
}
