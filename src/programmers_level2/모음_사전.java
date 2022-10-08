package programmers_level2;

public class 모음_사전 {
    public int solution(String word) {
        int answer = word.length();
        String alphabets = "AEIOU";
        int[] gap = new int[]{781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            int idx = alphabets.indexOf(word.charAt(i));
            answer += gap[i] * idx;
        }

        return answer;
    }
}
