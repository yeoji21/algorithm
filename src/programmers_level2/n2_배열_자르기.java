package programmers_level2;

public class n2_배열_자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int idx = 0;
        for (long i = left; i < right + 1; i++) {
            int width = (int)(i / n);
            int height = (int)(i % n);
            answer[idx++] = Math.max(width, height) + 1;
        }

        return answer;
    }
}
