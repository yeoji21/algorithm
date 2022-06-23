package programmers_level1;

public class 삼진법_뒤집기 {
    public static void main(String[] args) {
        int solution = solution(125);
        System.out.println(solution);
    }

    public static int solution(int n) {
        StringBuilder sb = new StringBuilder();
        StringBuilder hexadecimal = getHexadecimal(n, sb);
        return getHex(hexadecimal.reverse().toString());
    }

    private static int getHex(String hexadecimal) {
        int result = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            result += Math.pow(3, i) * Integer.parseInt(String.valueOf(hexadecimal.charAt(hexadecimal.length() - i - 1)));
        }
        return result;
    }

    private static StringBuilder getHexadecimal(int n, StringBuilder sb) {
        while (n >= 3) {
            sb.insert(0, n % 3);
            n /= 3;
        }
        sb.insert(0, n);
        return sb;
    }
}
