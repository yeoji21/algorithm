package programmers_level2;

public class 모음_사전 {
    public static void main(String[] args) {
        int solution = solution("AAAE");
        System.out.println(solution);
    }

    public static int solution(String word) {
        char[] vowels = new char[]{'A', 'E', 'I', 'O', 'U'};
        int[] pastWords = new int[]{781, 156, 31, 6, 1};

        int result = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if(word.charAt(i) == vowels[j]) {
                    result += pastWords[i] * j + 1;
                    break;
                }
            }
        }

        return result;
    }

}
