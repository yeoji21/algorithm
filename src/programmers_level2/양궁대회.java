package programmers_level2;

public class 양궁대회 {
    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
    }

    public static int[] solution(int n, int[] info) {
        int maxScore = Integer.MIN_VALUE;

        for (int i = 10; i >= 0; i--) {
            int remainArrows = n;
            int score = 0;
            for (int j = i; j >= 0 && remainArrows > 0; j--) {
                remainArrows -= info[10 - j] + 1;
                if(remainArrows < 0) break;
                score += j;
            }
            System.out.println("==================================");
            System.out.println(score);
            maxScore = Math.max(maxScore, score);
        }

        return new int[]{};
    }
}
