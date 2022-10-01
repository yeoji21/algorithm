package programmers_level2;

public class _124_나라의_숫자 {
    public String solution(int n) {
        int[] num = {4, 1, 2};
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, num[n % 3]);
            n = (n - 1) / 3;
        }

        return sb.toString();
    }
}
