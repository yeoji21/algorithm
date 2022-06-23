package programmers_level1;

public class 자연수를_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        int length = String.valueOf(n).length();
        int[] result = new int[length];

        int idx = 0;
        while (n >= 10) {
            result[idx++] = (int) (n % 10);
            n = n / 10;
        }
        result[idx] = (int) n;

        return result;
    }
}
