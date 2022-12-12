package programmers_level3;

public class 최고의_집합 {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};

        int[] answer = new int[n];
        int remain = s % n;
        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
        }
        for (int i = n - remain; i < n; i++) {
            answer[i]++;
        }

        return answer;
    }
}
