package programmers_level2;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int count = 0;
        int removed = 0;

        while (!s.equals("1")) {
            int before = s.length();
            s = s.replace("0", "");
            int after = s.length();
            removed += before - after;
            s = Integer.toBinaryString(s.length());
            count++;
        }

        return new int[]{count, removed};
    }
}
