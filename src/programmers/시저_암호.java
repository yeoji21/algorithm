package programmers;

public class 시저_암호 {

    public static void main(String[] args) {
        String solution = solution("a B Z", 4);
        System.out.println(solution);
    }

    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);

            if(Character.isSpaceChar(target)){
                sb.append(" ");
                continue;
            }

            char moved = (char)(target + n);

            if(Character.isLowerCase(target) && moved > 'z'){
                int gap = moved - 'z' - 1;
                moved = (char)('a' + gap);
            }
            if(Character.isUpperCase(target) && moved > 'Z'){
                int gap = moved - 'Z' - 1;
                moved = (char)('A' + gap);
            }

            sb.append(moved);
        }

        return sb.toString();
    }
}
