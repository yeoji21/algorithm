package programmers_level2;

public class 모음_사전 {
    public int solution(String word) {
        String str = "AEIOU";
        int[] gap = {781, 156, 31, 6, 1};
        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {
            int idx = str.indexOf(word.charAt(i));
            answer += gap[i] * idx;
        }

        return answer;
    }
}
