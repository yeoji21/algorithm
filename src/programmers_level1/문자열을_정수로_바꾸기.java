package programmers_level1;

public class 문자열을_정수로_바꾸기 {
    public int solution(String s) {
        if(Character.isDigit(s.charAt(0)))
            return Integer.parseInt(s);
        else{
            if(s.charAt(0) == '-') return -1 * Integer.parseInt(s.substring(1));
            else return Integer.parseInt(s.substring(1));
        }
    }
}
