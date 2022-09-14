package programmers_level2;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int round = 0;
        int removedZero = 0;
        while (!s.equals("1")) {
            int before = s.length();
            s = s.replace("0", "");
            int after = s.length();
            removedZero += before - after;
            round++;
            s = Integer.toBinaryString(s.length());
        }

        return new int[]{round, removedZero};
    }
}
