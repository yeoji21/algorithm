package programmers_level2;

public class _124_나라의_숫자 {
    public static void main(String[] args) {
        String solution = solution(12);
        System.out.println(solution);
    }

    public static String solution(int n) {
        String[] num = {"4", "1", "2"};
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, num[n % 3]);
            n = (n - 1) / 3;
        }

        return sb.toString();
    }
}
