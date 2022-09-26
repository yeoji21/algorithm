package programmers_level2;

public class JedenCase_문자열_만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        sb.append(String.valueOf(s.charAt(0)).toUpperCase());
        for (int i = 1; i < s.length(); i++) {
            char target = s.charAt(i);
            if (i - 1 > 0 && s.charAt(i - 1) == ' ')
                target = String.valueOf(target).toUpperCase().charAt(0);
            sb.append(target);
        }

        return sb.toString();
    }
}
