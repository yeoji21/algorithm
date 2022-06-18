package programmers;

public class 가운데_글자_가져오기 {
    public static void main(String[] args) {
        String solution = solution("power");
        System.out.println(solution);
    }

    public static String solution(String s) {
//        String center = String.valueOf(s.charAt(s.length() / 2));
//        if(s.length() % 2 == 1) return center;
//        else return s.charAt(s.length() / 2 - 1) + center;

        return s.substring((s.length()-1) / 2, s.length()/2 + 1);
    }
}
