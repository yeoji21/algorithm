package programmers_level2;

public class n진수_게임 {
    public String solution2(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (sb.length() < m * t) {
            sb.append(Integer.toString(num++, n));
        }

        for (int i = p - 1; i < m * t; i += m) {
            result.append(sb.charAt(i));
        }

        return result.toString().toUpperCase();
    }

    public String solution(int n, int t, int m, int p) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int number = 0;
        int idx = 0;
        while (count < t) {
            String radix = Integer.toString(number, n);
            for (int i = 0; i < radix.length(); i++) {
                if (count < t && idx++ % m == (p - 1)) {
                    sb.append(radix.charAt(i));
                    count++;
                }
            }
            number++;
        }

        return sb.toString().toUpperCase();
    }
}
