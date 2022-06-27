package programmers_level2;

import java.math.BigInteger;

public class 오답_124_나라의_숫자 {
    public static void main(String[] args) {
        String solution = solution(28);
        System.out.println(solution);
    }

    public static String solution(int n) {
        String trichotomy = BigInteger.valueOf(n).toString(3);
        System.out.println(trichotomy);

        StringBuilder sb = new StringBuilder();

        char[] chars = trichotomy.toCharArray();

        for (int i = chars.length-1; i >= 0; i--) {
            char now = chars[i];
            if (now == '0' && i - 1 >= 0) {
                getaChar(chars, i);
            }
            sb.append(chars[i]);
        }

        sb.reverse();
        return sb.charAt(0) == '0' ? sb.substring(1) : sb.toString();
    }

    private static void getaChar(char[] chars, int i) {
        if(i - 1 < 0) return;
        chars[i] = '4';
        if(chars[i - 1] == '0') {
            getaChar(chars, i - 1);
        }
        if(chars[i - 1] == '1') chars[i - 1] = '0';
        if(chars[i - 1] == '2') chars[i - 1] = '1';
        if(chars[i - 1] == '4') chars[i - 1] = '2';
        else chars[i - 1] = '0';
    }
}
