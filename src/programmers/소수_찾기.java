package programmers;

public class 소수_찾기 {
    public int solution(int n) {
        boolean[] num = new boolean[n + 1];
        int result = 0;

        for (int i = 2; i < num.length; i++) {
            if (!num[i]) {
                result++;
                for (int j = 1; i*j <= n; j++) {
                    num[i * j] = true;
                }
            }
        }
        return result;
    }
}
